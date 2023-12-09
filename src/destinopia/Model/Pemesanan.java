package destinopia.Model;
import java.util.List;
import java.sql.SQLException;

public class Pemesanan {
    private int pemesananUID;

    public int getPemesananID() {
        return pemesananUID;
    }

    public void setPemesananID(int UID) {
        pemesananUID = UID;
    }

    public static void testPemesananID() {
        try {
            Database database = new Database();
            int userID = Session.getUserId();
                
            List<Integer> pemesananIDs = database.getAllPemesananId(userID);
    
            System.out.println("Pemesanan IDs for userID " + userID + ":");
            for (int pemesananID : pemesananIDs) {
                System.out.println(pemesananID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}   
