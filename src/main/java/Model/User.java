package Model;
import java.sql.PreparedStatement;
import java.util.List;

public class User implements ISQLable {
    String id;
    String Email;
    List<String> favoriteCategories;
    List<CalendarSession> imTheTeacher;
    List<CalendarSession> imTheStudent;

    @Override
    public String getPrimaryKey() {
        return null;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {

    }

    @Override
    public String getFieldsSQLWithValues() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }
}
