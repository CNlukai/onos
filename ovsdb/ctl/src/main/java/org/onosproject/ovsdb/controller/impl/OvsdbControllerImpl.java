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
package org.onosproject.ovsdb.controller.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.onlab.packet.MacAddress;
import org.onosproject.ovsdb.controller.DefaultEventSubject;
import org.onosproject.ovsdb.controller.OvsdbClientService;
import org.onosproject.ovsdb.controller.OvsdbConstant;
import org.onosproject.ovsdb.controller.OvsdbController;
import org.onosproject.ovsdb.controller.OvsdbEvent;
import org.onosproject.ovsdb.controller.OvsdbEvent.Type;
import org.onosproject.ovsdb.controller.OvsdbEventListener;
import org.onosproject.ovsdb.controller.OvsdbNodeId;
import org.onosproject.ovsdb.controller.OvsdbNodeListener;
import org.onosproject.ovsdb.controller.driver.OvsdbAgent;
import org.onosproject.ovsdb.lib.jsonrpc.Callback;
import org.onosproject.ovsdb.lib.message.TableUpdate;
import org.onosproject.ovsdb.lib.message.TableUpdates;
import org.onosproject.ovsdb.lib.message.UpdateNotification;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.table.Bridge;
import org.onosproject.ovsdb.lib.table.Interface;
import org.onosproject.ovsdb.lib.table.Port;
import org.onosproject.ovsdb.lib.table.TableGenerator;
import org.onosproject.ovsdb.lib.table.TableGenerator.OvsdbTable;
import org.onosproject.ovsdb.lib.utils.FromJsonUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

@Component(immediate = true)
@Service
public class OvsdbControllerImpl implements OvsdbController {

    public static final Logger log = LoggerFactory
            .getLogger(OvsdbControllerImpl.class);

    protected ConcurrentHashMap<OvsdbNodeId, OvsdbClientService> connectedNodes =
            new ConcurrentHashMap<OvsdbNodeId, OvsdbClientService>();

    protected OvsdbAgent agent = new OvsdbNodeAgent();
    protected MonitorCallBack updateCallback = new MonitorCallBack();

    protected Set<OvsdbNodeListener> ovsdbNodeListener = new CopyOnWriteArraySet<>();
    protected Set<OvsdbEventListener> ovsdbEventListener = new CopyOnWriteArraySet<>();

    protected ConcurrentHashMap<String, OvsdbClientService> requestNotification =
            new ConcurrentHashMap<String, OvsdbClientService>();

    protected ConcurrentHashMap<String, String> requestDbName =
            new ConcurrentHashMap<String, String>();

    private final Controller controller = new Controller();

    @Activate
    public void activate(ComponentContext context) {
        controller.start(agent, updateCallback);
    }

    @Deactivate
    public void deactivate() {
        controller.stop();
    }

    @Override
    public void addNodeListener(OvsdbNodeListener listener) {

        if (!ovsdbNodeListener.contains(listener)) {
            this.ovsdbNodeListener.add(listener);
        }
    }

    @Override
    public void removeNodeListener(OvsdbNodeListener listener) {

        this.ovsdbNodeListener.remove(listener);
    }

    @Override
    public void addOvsdbEventListener(OvsdbEventListener listener) {

        if (!ovsdbEventListener.contains(listener)) {
            this.ovsdbEventListener.add(listener);
        }
    }

    @Override
    public void removeOvsdbEventListener(OvsdbEventListener listener) {

        this.ovsdbEventListener.remove(listener);
    }

    @Override
    public List<OvsdbNodeId> getNodeIds() {

        return null;
    }

    @Override
    public OvsdbClientService getOvsdbClient(OvsdbNodeId nodeId) {

        return connectedNodes.get(nodeId);
    }

    /**
     * Implementation of an Ovsdb Agent which is responsible for keeping track
     * of connected node and the state in which they are.
     */
    public class OvsdbNodeAgent implements OvsdbAgent {
        private final Logger log = LoggerFactory
                .getLogger(OvsdbControllerImpl.class);

        @Override
        public void addConnectedNode(OvsdbNodeId nodeId,
                                     OvsdbClientService ovsdbClient) {

            if (connectedNodes.get(nodeId) != null) {
                return;
            } else {
                connectedNodes.put(nodeId, ovsdbClient);

                try {
                    List<String> dbNames = ovsdbClient.listDbs().get();
                    for (String dbName : dbNames) {
                        DatabaseSchema dbSchema;
                        dbSchema = ovsdbClient.getOvsdbSchema(dbName).get();
                        log.info("Begin to monitor tables");
                        String id = java.util.UUID.randomUUID().toString();
                        TableUpdates updates = ovsdbClient
                                .monitorTables(dbName, id).get();
                        requestDbName.put(id, dbName);
                        requestNotification.put(id, ovsdbClient);
                        if (updates != null) {
                            processTableUpdates(ovsdbClient, updates,
                                                dbSchema.name());
                        }
                    }
                } catch (InterruptedException e) {

                    e.printStackTrace();
                } catch (ExecutionException e) {

                    e.printStackTrace();
                }

                log.info("add node to provider");
                for (OvsdbNodeListener l : ovsdbNodeListener) {

                    l.nodeAdded(nodeId);
                }
                return;
            }
        }

        @Override
        public void removeConnectedNode(OvsdbNodeId nodeId) {

            connectedNodes.remove(nodeId);
            for (OvsdbNodeListener l : ovsdbNodeListener) {
                l.nodeRemoved(nodeId);
                log.info("add node to remove");
            }
        }
    }

    private void processTableUpdates(OvsdbClientService clientService,
                                     TableUpdates updates, String databaseName) {
        checkNotNull(clientService, "OvsdbClientService is not null");
        DatabaseSchema dbSchema;
        try {
            log.info("begin to process table updates");
            dbSchema = clientService.getOvsdbSchema(databaseName).get();
            for (String tableName : updates.result().keySet()) {

                TableUpdate update = updates.result().get(tableName);
                for (UUID uuid : (Set<UUID>) update.rows().keySet()) {
                    log.info("begin to process table updates {}, {}, {}",
                             uuid.toString(), databaseName, tableName);
                    Row row = clientService.getRow(databaseName, tableName,
                                                   uuid.toString());
                    clientService.updateOvsdbStore(databaseName, tableName,
                                                   uuid.toString(),
                                                   update.getNew(uuid));
                    if (update.getNew(uuid) != null) {
                        boolean isNewRow = (row == null) ? true : false;
                        if (isNewRow) {
                            if ("Port".equals(tableName)) {
                                dispatchEvent(clientService,
                                              update.getNew(uuid), null,
                                              OvsdbEvent.Type.PORT_ADDED,
                                              dbSchema);
                            }
                        } else {
                            // not process update.
                            return;
                        }

                    } else if (update.getOld(uuid) != null) {
                        clientService.removeRow(databaseName, tableName,
                                                uuid.toString());
                        if (update.getOld(uuid) != null) {
                            if ("Port".equals(tableName)) {
                                dispatchEvent(clientService, null,
                                              update.getOld(uuid),
                                              OvsdbEvent.Type.PORT_REMOVED,
                                              dbSchema);
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();
        }
    }

    private void dispatchEvent(OvsdbClientService clientService, Row newR,
                               Row oldR, Type eventType, DatabaseSchema dbSchema) {
        Port port = null;
        if (OvsdbEvent.Type.PORT_ADDED.equals(eventType)) {
            port = (Port) TableGenerator.getTable(dbSchema, newR,
                                                  OvsdbTable.PORT);
        } else if (OvsdbEvent.Type.PORT_REMOVED.equals(eventType)) {
            port = (Port) TableGenerator.getTable(dbSchema, oldR,
                                                  OvsdbTable.PORT);
        }
        if (port == null) {
            return;
        }
        try {
            Long dpid = getDpid(clientService, dbSchema);
            Set<UUID> interfaceUUIDs = (Set<UUID>) port.getInterfacesColumn()
                    .data();
            for (UUID intfUUID : interfaceUUIDs) {

                Row intfRow = clientService.getRow(OvsdbConstant.DATABASENAME,
                                                   "Interface",
                                                   intfUUID.toString());
                Interface intf = (Interface) TableGenerator
                        .getTable(dbSchema, intfRow, OvsdbTable.INTERFACE);
                String portType;

                portType = (String) intf.getTypeColumn().data();

                long localPort = getLocalPortNumber(clientService, intf);
                String[] macAndIfaceId = getMacAndIfaceid(intf);
                if (macAndIfaceId == null) {
                    return;
                }
                DefaultEventSubject eventSubject = new DefaultEventSubject(
                                                       MacAddress.valueOf(macAndIfaceId[0]),
                                                       null,
                                                       port.getName(),
                                                       localPort,
                                                       dpid,
                                                       portType,
                                                       macAndIfaceId[1]);
                for (OvsdbEventListener listner : ovsdbEventListener) {
                    listner.handle(new OvsdbEvent(eventType, eventSubject));
                }

            }
        } catch (Throwable e) {

            e.printStackTrace();
        }
    }

    private String[] getMacAndIfaceid(Interface intf) throws Throwable {
        Map<String, String> externalIds = (Map<String, String>) intf
                .getExternalIdsColumn().data();
        if (externalIds == null) {
            log.error("No external_ids seen in {}", intf);
            return null;
        }

        String attachedMac = externalIds.get(OvsdbConstant.EXTERNAL_ID_VM_MAC);
        if (attachedMac == null) {
            log.error("No AttachedMac seen in {}", intf);
            return null;
        }
        String ifaceid = externalIds
                .get(OvsdbConstant.EXTERNAL_ID_INTERFACE_ID);
        if (attachedMac == null) {
            log.error("No ifaceid seen in {}", intf);
            return null;
        }
        return new String[] {attachedMac, ifaceid};
    }

    private long getLocalPortNumber(OvsdbClientService ovsdbNode, Interface intf)
            throws Throwable {
        Set<Long> ofPorts = (Set<Long>) intf.getOpenFlowPortColumn().data();
        while (ofPorts == null || ofPorts.size() <= 0) {
            log.info("Could NOT Identify OF value for port {} on {}",
                     intf.getName(), ovsdbNode);
            return 0L;
        }
        return (long) ofPorts.toArray()[0];
    }

    private long getDpid(OvsdbClientService ovsdbNode, DatabaseSchema dbSchema)
            throws Throwable {
        try {
            String brIntId = ovsdbNode
                    .getBridgeUuid(OvsdbConstant.INTEGRATION_BRIDGE);
            log.info("the br-int datapathId is {}", brIntId);
            if (brIntId == null) {
                log.error("Unable to spot Bridge Identifier for {} in {}",
                          "br-int", ovsdbNode);
                return 0L;
            }

            return getDpid(ovsdbNode, brIntId, dbSchema);
        } catch (Exception e) {
            log.error("Error finding Integration Bridge's OF DPID", e);
            return 0L;
        }
    }

    private long getDpid(OvsdbClientService clientService, String brIntId,
                         DatabaseSchema dbSchema) throws Throwable {
        Row bridgeRow = clientService.getRow(OvsdbConstant.DATABASENAME,
                                             "Bridge", brIntId);
        Bridge bridge = (Bridge) TableGenerator.getTable(dbSchema, bridgeRow,
                                                         OvsdbTable.BRIDGE);
        Set<String> dpids = (Set<String>) bridge.getDatapathIdColumn()
                .data();
        if (dpids == null || dpids.size() == 0) {
            return 0L;
        }
        return stringToLong((String) dpids.toArray()[0]);
    }

    private long stringToLong(String values) {
        long value = (new BigInteger(values.replaceAll(":", ""), 16))
                .longValue();
        return value;
    }

    /**
     * Implementation of an Callback which is responsible for receiving request
     * infomation from ovsdb.
     */
    public class MonitorCallBack implements Callback {
        @Override
        public void update(UpdateNotification upadateNotification) {
            Object key = upadateNotification.context();
            OvsdbClientService ovsdbClient = requestNotification.get(key);

            String dbName = requestDbName.get(key);
            JsonNode updatesJson = upadateNotification.tbUpdatesJsonNode();
            DatabaseSchema dbSchema = ovsdbClient.getDatabaseSchema(dbName);
            TableUpdates updates = FromJsonUtil
                    .jsonNodeToTableUpdates(updatesJson, dbSchema);
            processTableUpdates(ovsdbClient, updates, dbName);
        }

        @Override
        public void locked(List<String> ids) {

        }

        @Override
        public void stolen(List<String> ids) {

        }

    }

}
