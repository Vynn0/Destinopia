package destinopia.Model;

public class Session {
    private static String loggedUsername;
    private static int loggedUserId;

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
}