package destinopia.Model;

public class Session {
    private static String loggedName;

    public static String getLoggedName(){
        return loggedName;
    }

    public static void setLoggedName(String username) {
        loggedName = username;
    }
}
