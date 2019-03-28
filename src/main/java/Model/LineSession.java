package Model;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LineSession implements Model.ISQLable {
    public String id;
    public String category;
    public String subject;
    public Date beginTime;
    public Date endTime;
    public int price;
    public String name;
    public String email;
    public String userID;
    public String description;
    public int limitedNumber = 1;
    public int registered;

    public LineSession(String id, String category, String subject,
                       Date beginTime, Date endTime, int price,
                       String name, String email, String userID,
                       String description, int limitedNumber, int registered) {
        this.id = id;
        this.category = category;
        this.subject = subject;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.price = price;
        this.name = name;
        this.email = email;
        this.userID = userID;
        this.description = description;
        this.limitedNumber = limitedNumber;
        this.registered = registered;
    }

    public LineSession(String lineSession){
        this(lineSession.split(", "));
    }

    public LineSession(String[] lineSession) {
        this.id = lineSession[0];
        this.category = lineSession[1];
        this.subject = lineSession[2];
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.beginTime = formatter.parse(lineSession[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            this.endTime = formatter.parse(lineSession[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.price = Integer.parseInt(lineSession[5]);
        this.name = lineSession[6];
        this.email = lineSession[7];
        this.userID = lineSession[8];
        this.description = lineSession[9];

        this.limitedNumber = Integer.parseInt(lineSession[10]);
        this.registered = Integer.parseInt(lineSession[11]);
    }

    @Override
    public String getPrimaryKey() {
        return id;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {

       // Arrays.asList("sessionId","userId", "startTime", "endTime",
        // "price", "description", "limitedNumber", "registered");
        try {
            pstmt.setString(1, this.id);
            pstmt.setString(2, this.userID);
            pstmt.setString(3, this.beginTime.toString());
            pstmt.setString(4, this.endTime.toString());
            pstmt.setString(5, Integer.toString(this.price));
            pstmt.setString(6, this.description);
            pstmt.setString(7, Integer.toString(this.limitedNumber));
            pstmt.setString(8, Integer.toString(this.registered));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return TablesFields.enumDict.get("userFields").get(0) + "='" + this.id +
                "'," + TablesFields.enumDict.get("userFields").get(1) + "='" + this.userID +
                "'," + TablesFields.enumDict.get("userFields").get(2) + "='" + this.beginTime.toString() +
                "'," + TablesFields.enumDict.get("userFields").get(3) + "='" + this.endTime.toString() +
                "'," + TablesFields.enumDict.get("userFields").get(4) + "='" + Integer.toString(this.price) +
                "'," + TablesFields.enumDict.get("userFields").get(5) + "='" + this.description +
                "'," + TablesFields.enumDict.get("userFields").get(6) + "='" + Integer.toString(this.limitedNumber) +
                "'," + TablesFields.enumDict.get("userFields").get(7) + "='" + Integer.toString(this.registered) +
                "'\n";
    }

    @Override
    public String getTableName() {
        return Tables.TBL_SESSION.name();
    }
}
