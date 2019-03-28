package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterdSession implements ISQLable {

    //"RegistrationId", "RegistrationRegisteredUserId", "RegistrationSessionId")

    private String registrationId;
    private String registeredUserId;
    private String regSessionId;

    public RegisterdSession(String registrationId, String registeredUserId, String regSessionId) {
        this.registrationId = registrationId;
        this.registeredUserId = registeredUserId;
        this.regSessionId = regSessionId;
    }

    public RegisterdSession(String registeredSession){
        this(registeredSession.split(", "));
    }

    public RegisterdSession(String[] split) {
        this.registrationId = split[0];
        this.registeredUserId = split[1];
        this.regSessionId = split[2];
    }

    @Override
    public String getPrimaryKey() {
        return registrationId;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {
        try {
            pstmt.setString(1, this.registrationId);
            pstmt.setString(2, this.registeredUserId);
            pstmt.setString(3, this.regSessionId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return Model.TablesFields.enumDict.get(getTableName()).get(0) + "='" + this.registrationId +
                "'," + TablesFields.enumDict.get(getTableName()).get(1) + "='" + this.registeredUserId +
                "'," + TablesFields.enumDict.get(getTableName()).get(2) + "='" + this.regSessionId +
                "'\n";
    }

    @Override
    public String getTableName() {
        return Tables.TBL_REGISTERDSSESION.name();
    }
}
