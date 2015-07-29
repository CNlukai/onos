/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.ovsdb.controller.driver;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import org.onlab.packet.IpAddress;
import org.onosproject.ovsdb.controller.OvsdbBridge;
import org.onosproject.ovsdb.controller.OvsdbClientService;
import org.onosproject.ovsdb.controller.OvsdbConstant;
import org.onosproject.ovsdb.controller.OvsdbNodeId;
import org.onosproject.ovsdb.controller.OvsdbPort;
import org.onosproject.ovsdb.controller.OvsdbRowStore;
import org.onosproject.ovsdb.controller.OvsdbStore;
import org.onosproject.ovsdb.controller.OvsdbTableStore;
import org.onosproject.ovsdb.controller.OvsdbTunnel;
import org.onosproject.ovsdb.lib.jsonrpc.Callback;
import org.onosproject.ovsdb.lib.message.OperationResult;
import org.onosproject.ovsdb.lib.message.TableUpdates;
import org.onosproject.ovsdb.lib.notation.Condition;
import org.onosproject.ovsdb.lib.notation.Mutation;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;
import org.onosproject.ovsdb.lib.operations.Delete;
import org.onosproject.ovsdb.lib.operations.Insert;
import org.onosproject.ovsdb.lib.operations.Mutate;
import org.onosproject.ovsdb.lib.operations.Operation;
import org.onosproject.ovsdb.lib.operations.Update;
import org.onosproject.ovsdb.lib.schema.ColumnSchema;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.schema.TableSchema;
import org.onosproject.ovsdb.lib.table.Bridge;
import org.onosproject.ovsdb.lib.table.Controller;
import org.onosproject.ovsdb.lib.table.Interface;
import org.onosproject.ovsdb.lib.table.OpenVSwitch;
import org.onosproject.ovsdb.lib.table.Port;
import org.onosproject.ovsdb.lib.table.TableGenerator;
import org.onosproject.ovsdb.lib.table.TableGenerator.OvsdbTable;
import org.onosproject.ovsdb.lib.utils.ConditionUtil;
import org.onosproject.ovsdb.lib.utils.FromJsonUtil;
import org.onosproject.ovsdb.lib.utils.JsonRpcWriterUtil;
import org.onosproject.ovsdb.lib.utils.MutationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

/**
 * An representation of an ovsdb client.
 */
public class DefaultOvsdbClient
        implements OvsdbProviderService, OvsdbClientService {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private Channel channel;
    protected OvsdbNodeId nodeId;
    private OvsdbAgent agent;
    private Callback monitorCallBack;
    private boolean connected;
    private OvsdbStore ovsdbStore = new OvsdbStore();
    private Map<String, SettableFuture<? extends Object>> requestResult = Maps
            .newHashMap();
    private Map<String, String> requestMethod = Maps.newHashMap();

    private Map<String, DatabaseSchema> schema = Maps.newHashMap();
    private Set<OvsdbTunnel> ovsdbTunnels = new HashSet<OvsdbTunnel>();
    private Set<OvsdbBridge> ovsdbBridges = new HashSet<OvsdbBridge>();
    private Set<OvsdbPort> ovsdbPorts = new HashSet<OvsdbPort>();

    /**
     * Creates an OvsdbClient.
     */
    public DefaultOvsdbClient(OvsdbNodeId nodeId) {
        super();
        this.nodeId = nodeId;
    }

    @Override
    public OvsdbNodeId nodeId() {
        return nodeId;
    }

    @Override
    public void setAgent(OvsdbAgent agent) {
        if (this.agent == null) {
            this.agent = agent;
        }
    }

    @Override
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void setConnection(boolean connected) {
        this.connected = connected;
    }

    @Override
    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public void nodeAdded() {
        this.agent.addConnectedNode(nodeId, this);
    }

    @Override
    public void nodeRemoved() {
        this.agent.removeConnectedNode(nodeId);
        channel.disconnect();
    }

    private OvsdbTableStore getTableStore(String dbName) {
        if (ovsdbStore == null) {
            return null;
        }
        return ovsdbStore.getOvsdbStore(dbName);
    }

    private OvsdbRowStore getRowStore(String dbName, String tableName) {
        OvsdbTableStore tableStore = getTableStore(dbName);
        if (tableStore == null) {
            return null;
        }
        return tableStore.getTableStore(tableName);
    }

    @Override
    public Row getRow(String dbName, String tableName, String uuid) {
        OvsdbTableStore tableStore = getTableStore(dbName);
        if (tableStore == null) {
            return null;
        }
        OvsdbRowStore rowStore = tableStore.getTableStore(tableName);
        if (rowStore == null) {
            return null;
        }
        return rowStore.getRowStore(uuid);
    }

    @Override
    public void removeRow(String dbName, String tableName, String uuid) {
        OvsdbTableStore tableStore = getTableStore(dbName);
        if (tableStore == null) {
            return;
        }
        OvsdbRowStore rowStore = tableStore.getTableStore(tableName);
        if (rowStore == null) {
            return;
        }
        rowStore.removeRowStore(uuid);
    }

    @Override
    public void updateOvsdbStore(String dbName, String tableName, String uuid,
                                 Row row) {
        OvsdbTableStore tableStore = ovsdbStore.getOvsdbStore(dbName);
        if (tableStore == null) {
            tableStore = new OvsdbTableStore();
        }
        OvsdbRowStore rowStore = tableStore.getTableStore(tableName);
        if (rowStore == null) {
            rowStore = new OvsdbRowStore();
        }
        rowStore.setRowStore(uuid, row);
    }

    @Override
    public String getPortUuid(String portName, String bridgeName,
                              String bridgeUUID) {
        Row bridgeRow = getRow(OvsdbConstant.DATABASENAME, bridgeName,
                               bridgeUUID);
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Bridge bridge = (Bridge) TableGenerator.getTable(dbSchema, bridgeRow,
                                                         OvsdbTable.BRIDGE);
        if (bridge != null) {
            Set<UUID> ports;
            try {
                ports = (Set<UUID>) bridge.getPortsColumn().data();
                for (UUID portUUID : ports) {
                    Row portRow = getRow(OvsdbConstant.DATABASENAME, portName,
                                         portUUID.toString());
                    Port port = (Port) TableGenerator.getTable(dbSchema,
                                                               portRow,
                                                               OvsdbTable.PORT);
                    if (port != null
                            && portName.equalsIgnoreCase(port.getName())) {
                        return portUUID.toString();
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getInterfaceUuid(String portUuid, String portName) {
        String interfaceUuid = null;
        Row portRow = getRow(OvsdbConstant.DATABASENAME, portName, portUuid);
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Port port = (Port) TableGenerator.getTable(dbSchema, portRow,
                                                   OvsdbTable.PORT);
        try {
            Set<UUID> interfaces = (Set<UUID>) port.getInterfacesColumn()
                    .data();
            if (interfaces == null || interfaces.size() == 0) {
                return null;
            }
            interfaceUuid = interfaces.toArray()[0].toString();
            Row intfRow = getRow(OvsdbConstant.DATABASENAME, portName,
                                 interfaceUuid);
            Interface intf = (Interface) TableGenerator
                    .getTable(dbSchema, intfRow, OvsdbTable.INTERFACE);
            if (intf == null) {
                interfaceUuid = null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return interfaceUuid;
    }

    @Override
    public String getBridgeUuid(String bridgeName) {
        String bridgeUuid = null;
        OvsdbRowStore rowStore = getRowStore(OvsdbConstant.DATABASENAME,
                                             bridgeName);
        ConcurrentMap<String, Row> bridgeTable = rowStore.getRowStore();
        if (bridgeTable != null) {
            for (String uuid : bridgeTable.keySet()) {
                log.info("the uuid is {}", uuid);
                DatabaseSchema dbSchema = schema
                        .get(OvsdbConstant.DATABASENAME);
                Bridge bridge = (Bridge) TableGenerator
                        .getTable(dbSchema, bridgeTable.get(uuid),
                                  OvsdbTable.BRIDGE);
                try {
                    if (bridge.getName().equals(bridgeName)) {
                        bridgeUuid = uuid;
                        log.info("the bridge uuid is {} success", bridgeUuid);
                        break;
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("the bridge uuid is {}", bridgeUuid);
        return bridgeUuid;
    }

    @Override
    public String getControllerUuid(String controllerName,
                                    String controllerTarget) {
        String curControllerUuid = null;
        OvsdbRowStore rowStore = getRowStore(OvsdbConstant.DATABASENAME,
                                             controllerName);
        ConcurrentMap<String, Row> controllerTable = rowStore.getRowStore();
        if (controllerTable != null) {
            for (String uuid : controllerTable.keySet()) {
                DatabaseSchema dbSchema = schema
                        .get(OvsdbConstant.DATABASENAME);
                Controller controller = (Controller) TableGenerator
                        .getTable(dbSchema, controllerTable.get(uuid),
                                  OvsdbTable.CONTROLLER);
                String target;
                try {
                    target = (String) controller.getTargetColumn().data();
                    if (target.equalsIgnoreCase(controllerTarget)) {
                        curControllerUuid = uuid;
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        return curControllerUuid;
    }

    @Override
    public String getOvsUuid(String dbName) {
        DatabaseSchema dbSchema = schema.get(dbName);
        OpenVSwitch ovs = (OpenVSwitch) TableGenerator
                .getTable(dbSchema, null, OvsdbTable.OPENVSWITCH);
        try {
            return ovs.getUuid().toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createPort(String bridgeName, String portName) {
        String bridgeUuid = getBridgeUuid(bridgeName);
        if (bridgeUuid == null) {
            log.error("Could not find Bridge {} in {}", bridgeName, nodeId);
            return;
        }
        String portUuid = getPortUuid(portName, bridgeName, bridgeUuid);
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Port port = (Port) TableGenerator
                .createTable(dbSchema, OvsdbTable.PORT);
        try {
            port.setName(portName);
            if (portUuid == null) {
                insertRow("Port", "_uuid", "Bridge", "ports", bridgeUuid,
                          port.getRow());
            } else {
                updateRow("Port", "_uuid", portUuid, port.getRow());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void dropPort(String bridgeName, String portName) {
        String bridgeUuid = getBridgeUuid(bridgeName);
        if (bridgeUuid == null) {
            log.error("Could not find Bridge {} in {}", bridgeName, nodeId);
            return;
        }
        String portUuid = getPortUuid(portName, bridgeName, bridgeUuid);
        if (portUuid != null) {
            deleteTransact("Port", "_uuid", portUuid, "Bridge", "ports");
            log.info("Port {} delete status", portName);
        }
    }

    @Override
    public void createBridge(String bridgeName) {
        String bridgeUuid = getBridgeUuid(bridgeName);
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Bridge bridge = (Bridge) TableGenerator.createTable(dbSchema,
                                                            OvsdbTable.BRIDGE);
        Set<String> failModes = new HashSet<>();
        failModes.add("secure");
        try {
            bridge.setFailMode(failModes);
            Set<String> protocols = new HashSet<>();
            protocols.add(OvsdbConstant.OPENFLOW13);
            bridge.setProtocols(protocols);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        String ovsUuid = getOvsUuid(OvsdbConstant.DATABASENAME);
        if (bridgeUuid == null) {
            try {
                bridge.setName(bridgeName);
                bridgeUuid = insertRow("Bridge", "_uuid", "Open_vSwitch",
                                       "bridges", ovsUuid, bridge.getRow());
                Port port = (Port) TableGenerator.createTable(dbSchema,
                                                              OvsdbTable.PORT);
                port.setName(bridgeName);
                String tunnelPortUUID = insertRow("Port", "_uuid", "Bridge",
                                                  "ports", bridgeUuid,
                                                  port.getRow());
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            updateRow("Bridge", "_uuid", bridgeUuid, bridge.getRow());
        }
        setController(bridgeUuid);
    }

    /**
     * Sets the Controller.
     *
     * @param bridgeUuid bridge uuid
     */
    private void setController(String bridgeUuid) {
        String controllerUuid = null;
        String ofControllerIpAddress = nodeId.getIpAddress();
        int ofControllerPort = OvsdbConstant.OFPORT;
        String controllerSet = "tcp:" + ofControllerIpAddress + ":"
                + ofControllerPort;
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Controller controller = (Controller) TableGenerator
                .createTable(dbSchema, OvsdbTable.CONTROLLER);
        try {
            controller.setTarget(controllerSet);
            controllerUuid = getControllerUuid("Controller", controllerSet);
            if (controllerUuid == null) {
                insertRow("Controller", "_uuid", "Bridge", "controller",
                          bridgeUuid, controller.getRow());
            } else {
                Bridge bridge = (Bridge) TableGenerator
                        .createTable(dbSchema, OvsdbTable.BRIDGE);
                Set<UUID> controllerUuids = new HashSet<>();
                controllerUuids.add(UUID.uuid(controllerUuid));
                bridge.setController(controllerUuids);
                updateRow("Controller", "_uuid", bridgeUuid, bridge.getRow());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropBridge(String bridgeName) {
        String bridgeUUID = getBridgeUuid(bridgeName);
        if (bridgeUUID == null) {
            log.error("Could not find Bridge {}", nodeId);
            return;
        }
        deleteTransact("Bridge", "_uuid", bridgeUUID, "Open_vSwitch", "bridges");
    }

    @Override
    public void createTunnel(IpAddress srcIp, IpAddress dstIp) {
        String bridgeName = OvsdbConstant.INTEGRATION_BRIDGE;
        String bridgeUuid = getBridgeUuid(OvsdbConstant.INTEGRATION_BRIDGE);
        if (bridgeUuid == null) {
            log.error("Could not find Bridge {} in {}",
                      OvsdbConstant.INTEGRATION_BRIDGE, nodeId);
            return;
        }
        String portName = getTunnelName(OvsdbConstant.TYPEVXLAN, dstIp);
        String portUuid = getPortUuid(portName, bridgeName, bridgeUuid);
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        Port port = (Port) TableGenerator
                .createTable(dbSchema, OvsdbTable.PORT);
        try {
            port.setName(portName);
        } catch (Throwable e1) {
            e1.printStackTrace();
        }
        if (portUuid == null) {
            insertRow("Port", "_uuid", "Bridge", "ports", bridgeUuid,
                      port.getRow());
        } else {
            updateRow("Port", "_uuid", portUuid, port.getRow());
        }
        String interfaceUuid = null;
        int timeout = 6;
        while ((interfaceUuid == null) && (timeout > 0)) {
            // Wait for the ovsdb update to sync up the Local cache.
            interfaceUuid = getInterfaceUuid(portUuid, portName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeout--;
            continue;
        }
        if (interfaceUuid == null) {
            log.error("Cannot identify Tunnel Interface for port {}/{}",
                      portName, interfaceUuid);
            return;
        }
        Interface tunInterface = (Interface) TableGenerator
                .createTable(dbSchema, OvsdbTable.INTERFACE);
        try {
            tunInterface.setType(OvsdbConstant.TYPEVXLAN);
            Map<String, String> options = Maps.newHashMap();
            options.put("key", "flow");
            options.put("local_ip", srcIp.toString());
            options.put("remote_ip", dstIp.toString());
            tunInterface.setOptions(options);
            updateRow("Interface", "_uuid", interfaceUuid,
                      tunInterface.getRow());
            log.info("Tunnel {} add status", tunInterface);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void dropTunnel(IpAddress srcIp, IpAddress dstIp) {
        String bridgeName = OvsdbConstant.INTEGRATION_BRIDGE;
        String portName = getTunnelName(OvsdbConstant.TYPEVXLAN, dstIp);
        String bridgeUuid = getBridgeUuid(OvsdbConstant.INTEGRATION_BRIDGE);
        if (bridgeUuid == null) {
            log.error("Could not find Bridge {} in {}", bridgeName, nodeId);
            return;
        }
        String portUUID = getPortUuid(portName, bridgeName, bridgeUuid);
        if (portUUID != null) {
            deleteTransact("Port", "_uuid", portUUID, "Bridge", "ports");
            log.info("Port {} delete status", portName);
        }
    }

    /**
     * Delete transact config.
     *
     * @param childTable child table name
     * @param childColumn child column name
     * @param childRowUuid child row uuid
     * @param parentTable parent table name
     * @param parentColumn parent column
     *
     */
    private void deleteTransact(String childTable, String childColumn,
                                String childRowUuid, String parentTable,
                                String parentColumn) {
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        TableSchema childTableSchema = dbSchema.getTableSchema(childTable);
        ColumnSchema childColumnSchema = childTableSchema
                .getColumnSchema(childColumn);
        ArrayList<Operation> operations = Lists.newArrayList();
        if (parentTable != null && parentColumn != null) {
            TableSchema parentTableSchema = dbSchema
                    .getTableSchema(parentTable);
            ColumnSchema parentColumnSchema = parentTableSchema
                    .getColumnSchema(parentColumn);
            List<Mutation> mutations = Lists.newArrayList();
            Mutation mutation = MutationUtil.delete(parentColumnSchema.name(),
                                                    childRowUuid);
            mutations.add(mutation);
            List<Condition> conditions = Lists.newArrayList();
            Condition condition = ConditionUtil.includes(parentColumn,
                                                         childRowUuid);
            conditions.add(condition);
            Mutate op = new Mutate(parentTableSchema, conditions, mutations);
            operations.add(op);
        }
        List<Condition> conditions = Lists.newArrayList();
        Condition condition = ConditionUtil.equals(childColumn, childRowUuid);
        conditions.add(condition);
        Delete del = new Delete(childTableSchema, conditions);
        operations.add(del);
        ListenableFuture<List<OperationResult>> results = transactConfig(OvsdbConstant.DATABASENAME,
                                                                         operations);
        return;
        // exception handle
    }

    /**
     * Update transact config.
     *
     * @param table table name
     * @param column column name
     * @param uuid uuid
     * @param row the config data
     *
     */
    private void updateRow(String table, String column, String uuid, Row row) {
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        TableSchema tableSchema = dbSchema.getTableSchema(table);
        List<Condition> conditions = Lists.newArrayList();
        Condition condition = ConditionUtil.equals(column, uuid);
        conditions.add(condition);
        Update update = new Update(tableSchema, row, conditions);
        ArrayList<Operation> operations = Lists.newArrayList();
        operations.add(update);
        ListenableFuture<List<OperationResult>> results = transactConfig(OvsdbConstant.DATABASENAME,
                                                                         operations);
        // exception handle
    }

    /**
     * Insert transact config.
     *
     * @param childTable child table name
     * @param childColumn child column name
     * @param childRowUuid child row uuid
     * @param parentTable parent table name
     * @param parentColumn parent column
     * @param row the config data
     *
     * @return uuid, empty if no uuid is find
     */
    private String insertRow(String childtable, String childColumn,
                             String parentTable, String parentColumn,
                             String parentsUUID, Row row) {
        DatabaseSchema dbSchema = schema.get(OvsdbConstant.DATABASENAME);
        TableSchema tableSchema = dbSchema.getTableSchema(childtable);
        Insert insert = new Insert(tableSchema, childtable, row);
        ArrayList<Operation> operations = Lists.newArrayList();
        operations.add(insert);
        if (parentTable != null && parentColumn != null) {
            TableSchema parentTableSchema = dbSchema
                    .getTableSchema(parentTable);
            ColumnSchema parentColumnSchema = parentTableSchema
                    .getColumnSchema(parentColumn);
            List<Mutation> mutations = Lists.newArrayList();
            Mutation mutation = MutationUtil.insert(parentColumnSchema.name(),
                                                    childtable);
            mutations.add(mutation);
            List<Condition> conditions = Lists.newArrayList();
            Condition condition = ConditionUtil.equals(parentColumn,
                                                       parentsUUID);
            conditions.add(condition);
            Mutate op = new Mutate(parentTableSchema, conditions, mutations);
            operations.add(op);
        }
        List<OperationResult> results;
        try {
            results = transactConfig(OvsdbConstant.DATABASENAME, operations)
                    .get();
            UUID uuid = results.get(0).getUuid();
            return uuid.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // exception handle
        return null;
    }

    /**
     * Gets tunnel name.
     *
     * @param tunnelType
     * @param dstIp the remot ip address
     *
     * @return tunnel name
     */
    private String getTunnelName(String tunnelType, IpAddress dstIp) {
        return tunnelType + "-" + dstIp.toString();
    }

    @Override
    public ListenableFuture<DatabaseSchema> getOvsdbSchema(String dbName) {
        if (dbName == null) {
            return null;
        }
        DatabaseSchema databaseSchema = schema.get(dbName);
        if (databaseSchema == null) {
            log.info("Get ovsdb database shema dbSchema is null");
            List<String> dbNames = new ArrayList<String>();
            dbNames.add(dbName);
            Function<JsonNode, DatabaseSchema> rowFunction = new Function<JsonNode, DatabaseSchema>() {
                @Override
                public DatabaseSchema apply(JsonNode input) {
                    log.info("Get ovsdb database shema");
                    DatabaseSchema dbSchema = FromJsonUtil
                            .jsonNodeToDbSchema(dbName, input);
                    schema.put(dbName, dbSchema);
                    log.info("Get ovsdb database shema end");
                    return dbSchema;
                }
            };
            ListenableFuture<JsonNode> input = getSchema(dbNames);
            if (input != null) {
                try {
                    log.info("input message: {}", input.get().toString());
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return Futures.transform(input, rowFunction);
        } else {
            return Futures.immediateFuture(databaseSchema);
        }
    }

    @Override
    public ListenableFuture<TableUpdates> monitorTables(String dbName, String id) {
        if (dbName == null) {
            return null;
        }
        DatabaseSchema dbSchema = schema.get(dbName);
        if (dbSchema != null) {
            Function<JsonNode, TableUpdates> rowFunction = new Function<JsonNode, TableUpdates>() {
                @Override
                public TableUpdates apply(JsonNode input) {
                    TableUpdates updates = FromJsonUtil
                            .jsonNodeToTableUpdates(input, dbSchema);
                    return updates;
                }
            };
            return Futures.transform(monitor(dbSchema, id), rowFunction);
        }
        return null;
    }

    @Override
    public ListenableFuture<List<OperationResult>> transactConfig(String dbName,
                                                                  List<Operation> operations) {
        if (dbName == null) {
            return null;
        }
        DatabaseSchema dbSchema = schema.get(dbName);
        if (dbSchema != null) {
            Function<List<JsonNode>, List<OperationResult>> rowFunction =
                    new Function<List<JsonNode>, List<OperationResult>>() {
                @Override
                public List<OperationResult> apply(List<JsonNode> input) {
                    List<OperationResult> result = FromJsonUtil
                            .jsonNodeToOperationResult(input, operations);
                    return result;
                }
            };
            return Futures.transform(transact(dbSchema, operations),
                                     rowFunction);
        }
        return null;
    }

    @Override
    public ListenableFuture<JsonNode> getSchema(List<String> dbnames) {
        String id = java.util.UUID.randomUUID().toString();
        try {
            String getSchemaString = JsonRpcWriterUtil
                    .getSchemaStr(id, dbnames);
            SettableFuture<JsonNode> sf = SettableFuture.create();
            requestResult.put(id, sf);
            requestMethod.put(id, "getSchema");
            log.info("The getSchema jsonnode {}", getSchemaString);
            channel.writeAndFlush(getSchemaString);
            return sf;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ListenableFuture<List<String>> echo() {
        String id = java.util.UUID.randomUUID().toString();
        try {
            String echoString = JsonRpcWriterUtil.echoStr(id);
            SettableFuture<List<String>> sf = SettableFuture.create();
            requestResult.put(id, sf);
            requestMethod.put(id, "echo");
            channel.writeAndFlush(echoString);
            return sf;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ListenableFuture<JsonNode> monitor(DatabaseSchema dbSchema,
                                              String monitorId) {
        String id = java.util.UUID.randomUUID().toString();
        try {
            String monitorString = JsonRpcWriterUtil.monitorStr(id, monitorId,
                                                                dbSchema);
            SettableFuture<JsonNode> sf = SettableFuture.create();
            requestResult.put(id, sf);
            requestMethod.put(id, "monitor");
            channel.writeAndFlush(monitorString);
            return sf;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ListenableFuture<List<String>> listDbs() {
        String id = java.util.UUID.randomUUID().toString();
        try {
            String listDbsString = JsonRpcWriterUtil.listDbsStr(id);
            requestMethod.put(id, "listDbs");
            SettableFuture<List<String>> sf = SettableFuture.create();
            requestResult.put(id, sf);
            channel.writeAndFlush(listDbsString);
            return sf;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ListenableFuture<List<JsonNode>> transact(DatabaseSchema dbSchema,
                                                     List<Operation> operations) {
        String id = java.util.UUID.randomUUID().toString();
        try {
            String transactString = JsonRpcWriterUtil.transactStr(id, dbSchema,
                                                                  operations);
            SettableFuture<List<JsonNode>> sf = SettableFuture.create();
            requestResult.put(id, sf);
            requestMethod.put(id, "transact");
            channel.writeAndFlush(transactString);
            return sf;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void processResult(JsonNode response) {
        //log.info("Response : {}", response.toString());
        String requestId = response.get("id").asText();
        SettableFuture sf = requestResult.get(requestId);
        if (sf == null) {
            return;
        }
        String methodName = requestMethod.get(requestId);
        log.info("result method is {}", methodName);
        Object result;
        try {
//            if (methodName.equalsIgnoreCase("getSchema")) {
//                log.info("getSchema result success");
//                sf.set((Object) response);
//                return;
//            }
            result = FromJsonUtil.jsonResultParser(response, methodName);
            sf.set(result);
            log.info("result method result is success {}", methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processRequest(JsonNode requestJson) {
        log.info("handle request");
        if (requestJson.get("method").asText().equalsIgnoreCase("echo")) {
            log.info("handle echo request");
            String replyString = FromJsonUtil.getEchoRequestStr(requestJson);
            channel.writeAndFlush(replyString);
            return;
        } else {
            FromJsonUtil
                    .jsonCallbackRequestParser(requestJson, monitorCallBack);
            return;
        }
    }

    @Override
    public void setCallback(Callback monitorCallback) {
        this.monitorCallBack = monitorCallback;
    }

    @Override
    public Set<OvsdbTunnel> getTunnels() {
        return ovsdbTunnels;
    }

    @Override
    public Set<OvsdbBridge> getBridges() {
        return ovsdbBridges;
    }

    @Override
    public Set<OvsdbPort> getPorts() {
        return ovsdbPorts;
    }

    @Override
    public DatabaseSchema getDatabaseSchema(String dbName) {
        return schema.get(dbName);
    }
}
