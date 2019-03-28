package Model;

//When adding a new table, add the exact table name to the Tables Enum!

import java.sql.PreparedStatement;

public interface ISQLable {
    String getPrimaryKey();
    void insertRecordToTable(PreparedStatement pstmt);
    String getFieldsSQLWithValues();
    String getTableName();
}
