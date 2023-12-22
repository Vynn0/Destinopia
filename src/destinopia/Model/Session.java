package destinopia.Model;

public class Session {
    private static String loggedUsername;
    private static int loggedUserId;
    private static String loggedEmail;

    public static String getLoggedName() {
        return loggedUsername;
    }

    public static void setLoggedName(String username) {
        loggedUsername = username;
    }

    public static int getUserId() {
        return loggedUserId;
    }

    public static void setUserId(int userId) {
        loggedUserId = userId;
    }

    public static String getLoggedEmail() {
        return loggedEmail;
    }

    public static void setLoggedEmail(String email){
        loggedEmail = email;
    }

    public static void clearSession(){
        loggedUsername = null;
        loggedUserId = 0;
        loggedEmail = null;
    }
}