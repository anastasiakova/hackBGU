package Model;
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
    public String getPrimaryKeyName() {
        return null;
    }

    @Override
    public String getTableFields() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }
}
