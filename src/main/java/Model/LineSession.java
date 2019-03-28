package Model;

import java.util.Date;

public class LineSession implements ISQLable {
    public String category;
    public String subject;
    public Date beginTime;
    public Date endTime;
    public int price;
    public String name;
    public String email;
    public String description;

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
