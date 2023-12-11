package destinopia.Model;

public class Pemesanan {
    private int pemesananUID;
    private String location;
    private String airline;
    private String airport;
    private String terminal;

    // Setter getter column pemesanan
    public String getLocation() { // Getter ini digunakan untuk display label
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

    // Mengambil column dari database
    public Pemesanan(int pemesananUID, String location, String airline, String airport, String terminal) {
        this.pemesananUID = pemesananUID;
        this.location = location;
        this.airline = airline;
        this.airport = airport;
        this.terminal = terminal;
    }
}
