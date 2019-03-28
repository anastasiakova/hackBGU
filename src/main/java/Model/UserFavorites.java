package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserFavorites implements ISQLable {

    private String favID;
    private String userId;
    private String catName;

    public UserFavorites(String favID, String userId, String catName) {
        this.favID = favID;
        this.userId = userId;
        this.catName = catName;
    }

    public UserFavorites(String userFavorites){
        this(userFavorites.split(", "));
    }

    public UserFavorites(String[] split) {
        this.favID = split[0];
        this.userId = split[1];
        this.catName = split[2];
    }

    //"userFavoritesId", "userFavoritesUserId", "userFavoritesCategoryName");

    @Override
    public String getPrimaryKey() {
        return favID;
    }

    @Override
    public void insertRecordToTable(PreparedStatement pstmt) {
        try {
            pstmt.setString(1, this.favID);
            pstmt.setString(2, this.userId);
            pstmt.setString(3, this.catName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getFieldsSQLWithValues() {
        return Model.TablesFields.enumDict.get(getTableName()).get(0) + "='" + this.favID +
                "'," + TablesFields.enumDict.get(getTableName()).get(1) + "='" + this.userId +
                "'," + TablesFields.enumDict.get(getTableName()).get(2) + "='" + this.catName +
                "'\n";
    }

    @Override
    public String getTableName() {
        return Tables.TBL_USERFAVORITES.name();
    }
}
