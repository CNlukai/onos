package org.onosproject.ovsdb.lib.table;

import java.util.Map;

import org.onosproject.ovsdb.lib.notation.Column;
import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.schema.DatabaseSchema;
import org.onosproject.ovsdb.lib.tableservice.AbstractOvsdbTableService;
import org.onosproject.ovsdb.lib.tableservice.ColumnDescription;

/**
 * This class provides operations of SSL Table.
 */
public class SSL extends AbstractOvsdbTableService {
    /**
     * Constructs a SSL object. Generate SSL Table Description.
     * @param dbSchema DatabaseSchema
     * @param row Row
     */
    public SSL(DatabaseSchema dbSchema, Row row) {
        super(dbSchema, row, "SSL", "1.0.0");
        if (row != null) {
            row.setTableSchema(dbSchema.getTableSchema("SSL"));
        }
    }

    /**
     * Get the Column entity which column name is "ca_cert" from the Row entity
     * of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getCaCertColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ca_cert",
                                                             "getCaCertColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "ca_cert" to the Row entity of
     * attributes.
     * @param caCert the column data which column name is "ca_cert"
     * @throws Throwable
     */
    public void setCaCert(String caCert) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("ca_cert",
                                                             "setCaCert",
                                                             "1.0.0");
        super.setDataHandler(columndesc, caCert);
    }

    /**
     * Get the Column entity which column name is "external_ids" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getExternalIdsColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "external_ids",
                                                             "getExternalIdsColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "external_ids" to the Row entity
     * of attributes.
     * @param externalIds the column data which column name is "external_ids"
     * @throws Throwable
     */
    public void setExternalIds(Map<String, String> externalIds)
            throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("external_ids",
                                                             "setExternalIds",
                                                             "1.0.0");
        super.setDataHandler(columndesc, externalIds);
    }

    /**
     * Get the Column entity which column name is "bootstrap_ca_cert" from the
     * Row entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getBootstrapCaCertColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bootstrap_ca_cert",
                                                             "getBootstrapCaCertColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "bootstrap_ca_cert" to the Row
     * entity of attributes.
     * @param bootstrapCaCert the column data which column name is
     *            "bootstrap_ca_cert"
     * @throws Throwable
     */
    public void setBootstrapCaCert(Boolean bootstrapCaCert) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "bootstrap_ca_cert",
                                                             "setBootstrapCaCert",
                                                             "1.0.0");
        super.setDataHandler(columndesc, bootstrapCaCert);
    }

    /**
     * Get the Column entity which column name is "certificate" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getCertificateColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "certificate",
                                                             "getCertificateColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "certificate" to the Row entity
     * of attributes.
     * @param certificate the column data which column name is "certificate"
     * @throws Throwable
     */
    public void setCertificate(String certificate) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("certificate",
                                                             "setCertificate",
                                                             "1.0.0");
        super.setDataHandler(columndesc, certificate);
    }

    /**
     * Get the Column entity which column name is "private_key" from the Row
     * entity of attributes.
     * @return the Column entity
     * @throws Throwable
     */
    public Column getPrivateKeyColumn() throws Throwable {
        ColumnDescription columndesc = new ColumnDescription(
                                                             "private_key",
                                                             "getPrivateKeyColumn",
                                                             "1.0.0");
        return (Column) super.getColumnHandler(columndesc);
    }

    /**
     * Add a Column entity which column name is "private_key" to the Row entity
     * of attributes.
     * @param privatekey the column data which column name is "private_key"
     * @throws Throwable
     */
    public void setPrivateKey(String privatekey) throws Throwable {
        ColumnDescription columndesc = new ColumnDescription("private_key",
                                                             "setPrivateKey",
                                                             "1.0.0");
        super.setDataHandler(columndesc, privatekey);
    }
}
