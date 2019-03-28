package Model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class User implements Model.ISQLable {
    private String id;
    private String email;
    List<String> favoriteCategories;
    List<Model.CalendarSession> imTheTeacher;
    List<Model.CalendarSession> imTheStudent;

    private String pws;
    String privateName;
    String lastName;

    @Override
    public String getPrimaryKey() {
        return id;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {
        try {
            pstmt.setString(1, this.id);
            pstmt.setString(2, this.pws);
            pstmt.setString(3, this.email);
            pstmt.setString(4, this.privateName);
            pstmt.setString(5, this.lastName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return Model.TablesFields.enumDict.get(getTableName()).get(0) + "='" + this.id +
                "'," + TablesFields.enumDict.get(getTableName()).get(1) + "='" + this.pws +
                "'," + TablesFields.enumDict.get(getTableName()).get(2) + "='" + this.email +
                "'," + TablesFields.enumDict.get(getTableName()).get(3) + "='" + this.privateName +
                "'," + TablesFields.enumDict.get(getTableName()).get(4) + "='" + this.lastName +
                "'\n";
    }

    @Override
    public String getTableName() {
        return "TBL_USERS";
    }
}
