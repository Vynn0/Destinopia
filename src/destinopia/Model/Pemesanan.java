package destinopia.Model;

import java.util.List;
import java.sql.SQLException;

public class Pemesanan {
    private int pemesananUID;
    private String location;
    private String airline;
    private String airport;
    private String terminal;

    // Setter getter column pemesanan
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getPemesananID() {
        return pemesananUID;
    }

    public void setPemesananID(int UID) {
        pemesananUID = UID;
    }

    // Mengambil column
    public Pemesanan(int pemesananUID, String location, String airline, String airport, String terminal) {
        this.pemesananUID = pemesananUID;
        this.location = location;
        this.airline = airline;
        this.airport = airport;
        this.terminal = terminal;
    }

    // Menggunakan override, akan mengganti model pemesanan yang di retrieve ke
    // string menggunakan "toString"
    @Override
    public String toString() {
        return "Pemesanan{" +
                "pemesananUID=" + pemesananUID +
                ", location='" + location + '\'' +
                ", airline='" + airline + '\'' +
                ", airport='" + airport + '\'' +
                ", terminal='" + terminal + '\'' +
                '}';
    }

    public static void testPemesananID() {
        try {
            Database database = new Database();
            int userID = Session.getUserId();

            List<Pemesanan> pemesananList = database.getAllPemesanan(userID);

            System.out.println("Pemesanan for userID " + userID + ":");
            for (Pemesanan pemesanan : pemesananList) {
                System.out.println(pemesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
