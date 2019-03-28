package Model;

//When adding a new table, add the exact table name to the Tables Enum!

public interface ISQLable {
    String getPrimaryKey();
    String getPrimaryKeyName();
    String getTableFields();
    String getTableName();
}
