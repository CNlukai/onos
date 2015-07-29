package org.onosproject.ovsdb.lib.message;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import org.onosproject.ovsdb.lib.notation.Row;
import org.onosproject.ovsdb.lib.notation.UUID;

public class RowUpdate {
    private final UUID uuid;
    private final Row oldRow;
    private final Row newRow;

    /**
     * Default Constructor.
     * @param uuid UUID
     * @param oldRow present for "delete" and "modify" updates
     * @param newRow present for "initial", "insert", and "modify" updates
     */
    public RowUpdate(UUID uuid, Row oldRow, Row newRow) {
        checkNotNull(uuid, "uuid is not null");
        this.uuid = uuid;
        this.oldRow = oldRow;
        this.newRow = newRow;
    }

    /**
     * Return uuid.
     * @return uuid
     */
    public UUID uuid() {
        return this.uuid;
    }

    /**
     * Return oldRow.
     * @return oldRow
     */
    public Row oldRow() {
        return oldRow;
    }

    /**
     * Return newRow.
     * @return newRow
     */
    public Row newRow() {
        return newRow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, oldRow, newRow);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RowUpdate) {
            final RowUpdate other = (RowUpdate) obj;
            return Objects.equals(this.uuid, other.uuid)
                    && Objects.equals(this.oldRow, other.oldRow)
                    && Objects.equals(this.newRow, other.newRow);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("uuid", uuid)
                .add("oldRow", oldRow).add("newRow", newRow)
                .toString();
    }
}
