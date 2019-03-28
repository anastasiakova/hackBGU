package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectSession implements ISQLable{

    //"categoryName", "sessionName");
    private String subjSessionID;
    private String catName;
    private String sessionID;

    public SubjectSession(String subjSessionID, String catName, String sessionID) {
        this.subjSessionID = subjSessionID;
        this.catName = catName;
        this.sessionID = sessionID;
    }

    public SubjectSession(String sessionID){
        this(sessionID.split(", "));
    }

    public SubjectSession(String[] split) {
        this.subjSessionID = split[0];
        this.catName = split[1];
        this.sessionID = split[2];
    }

    @Override
    public String getPrimaryKey() {
        return subjSessionID;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {
        try {
            pstmt.setString(1, this.subjSessionID);
            pstmt.setString(2, this.catName);
            pstmt.setString(3, this.sessionID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return Model.TablesFields.enumDict.get(getTableName()).get(0) + "='" + this.subjSessionID +
                "'," + TablesFields.enumDict.get(getTableName()).get(1) + "='" + this.catName +
                "'," + TablesFields.enumDict.get(getTableName()).get(2) + "='" + this.sessionID +
                "'\n";
    }

    @Override
    public String getTableName() {
        return Tables.TBL_SUBJECTSESSION.name();
    }
}
