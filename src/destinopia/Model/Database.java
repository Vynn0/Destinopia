package destinopia.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database() {
        databaseConnection();
    }

    // DB Connection
    private void databaseConnection() {
        try {
            // Melakukan koneksi menggunakan drivermanager SQL, ke database destinopia.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/destinopia", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add data
    public void addData(String name, String password, String email) {
        // Hashed pass
        String hashedPassword = hashPass(password);
        try {
            // Membuat query sebagai string
            String query = "INSERT INTO user (username, password, email) VALUES (?, ?, ?)";
            // Menyiapkan statement SQL dan melakukan koneksi ke database dengan query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Maybe add ID in here
            // Set string untuk urutan, dan parameter terakhir sebagai isi
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3, email);

            // Lakukan eksekusi
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPesanan(String location, String airline, String airport, String terminal, int userID) {
        try {
            String query = "INSERT INTO pemesanan (location, airline, airport, terminal, userID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location);
            preparedStatement.setString(2, airline);
            preparedStatement.setString(3, airport);
            preparedStatement.setString(4, terminal);
            preparedStatement.setInt(5, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String hashPass(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Fungsi MD sebagai SHA-256
            byte[] hashedBytes = md.digest(password.getBytes()); // Digest password yang bersifat string menjadi bytes

            StringBuilder hexString = new StringBuilder(); // Inisialisasi hexString
            for (byte b : hashedBytes) { // Mengubah bytes yang di hash menjadi hexadecimal bersifat string
                hexString.append(String.format("%02x", b)); // Append per bytes
            }

            return hexString.toString(); // Return
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle exception or throw a custom exception
            return null;
        }
    }

    public List<Pemesanan> getAllPemesanan(int userID) throws SQLException {
        List<Pemesanan> pemesananList = new ArrayList<>(); // Membuat
        try {
            String query = "SELECT * FROM pemesanan WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int pemesananID = resultSet.getInt("id");
                String location = resultSet.getString("location");
                String airline = resultSet.getString("airline");
                String airport = resultSet.getString("airport");
                String terminal = resultSet.getString("terminal");

                Pemesanan pemesanan = new Pemesanan(pemesananID, location, airline, airport, terminal);
                pemesananList.add(pemesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pemesananList;
    }

    // Login Validation
    public boolean loginCheck(String name, String password) {
        try {
            String hashedPassword = hashPass(password);
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Maybe add ID in here
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, hashedPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userID = resultSet.getInt("id");
                Session.setLoggedName(name);
                Session.setUserId(userID);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}