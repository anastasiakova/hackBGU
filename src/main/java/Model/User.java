package Model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class User implements Model.ISQLable {
    private String id;
    private String email;
    private String pwd;
    private String firstName;
    private String lastName;
    List<String> favoriteCategories;
    List<Model.CalendarSession> imTheTeacher;
    List<Model.CalendarSession> imTheStudent;

    public User(String id, String email, String pwd, String firstName,
                String lastName, List<String> favoriteCategories ){

        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteCategories = favoriteCategories;
        imTheStudent = getImTheStudent(id);
        imTheTeacher = getImTheTeacher(id);

    }

    private List<CalendarSession> getImTheTeacher(String id) {
        return null; //TODO Connect to DB
    }

    private List<CalendarSession> getImTheStudent(String id) {
        return null; //TODO Connect to DB
    }

    @Override
    public String getPrimaryKey() {
        return id;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {
        try {
            pstmt.setString(1, this.id);
            pstmt.setString(2, this.pwd);
            pstmt.setString(3, this.email);
            pstmt.setString(4, this.firstName);
            pstmt.setString(5, this.lastName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return Model.TablesFields.enumDict.get(getTableName()).get(0) + "='" + this.id +
                "'," + TablesFields.enumDict.get(getTableName()).get(1) + "='" + this.pwd +
                "'," + TablesFields.enumDict.get(getTableName()).get(2) + "='" + this.email +
                "'," + TablesFields.enumDict.get(getTableName()).get(3) + "='" + this.firstName +
                "'," + TablesFields.enumDict.get(getTableName()).get(4) + "='" + this.lastName +
                "'\n";
    }

    @Override
    public String getTableName() {
        return "TBL_USERS";
    }
}
