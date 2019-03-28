package Model;

import java.util.*;

public class TablesFields {

    public static Map<Tables, List<String>> enumDict = new HashMap<>();

    public static void initFields() {
        List<String> enumList = new ArrayList<String>();
        enumList = Arrays.asList("userId", "pwd", "email", "privateName",
                "lastName");
        enumDict.put(Tables.TBL_USERS, enumList);
        enumList = Arrays.asList("sessionId","userId" ,"date", "startTime", "endTime",
                "price", "description", "limitedNumber", "registered");
        enumDict.put(Tables.TBL_SESSION, enumList);
        enumList = Arrays.asList("subjectId", "subjectName", "subjectCategoryName");
        enumDict.put(Tables.TBL_SUBJECTS, enumList);
        enumList = Arrays.asList("categoryNameId");
        enumDict.put(Tables.TBL_CATEGORIES, enumList);
        enumList = Arrays.asList("categoryName", "sessionName");
        enumDict.put(Tables.TBL_SUBJECTSESSION, enumList);
        enumList = Arrays.asList("userFavoritesId", "userFavoritesUserId", "userFavoritesCategoryName");
        enumDict.put(Tables.TBL_USERFAVORITES, enumList);
        enumList = Arrays.asList("RegistrationId", "RegistrationRegisteredUserId", "RegistrationSessionId");
        enumDict.put(Tables.TBL_REGISTERDSSESION, enumList);
    }
}
