package destinopia.Model;

import java.sql.*;

public class Login {
    public static void isValidated() {
        // Set connection menjadi null
        Connection connection = null;
        try {
            // Connect ke database JDBC MySQL, localhost 3306, destinopia, dengan user
            // "root" dan tidak ada password
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/destinopia", "root", "");
        } catch (SQLException e) {
            // Jika ada exception, akan kirim connection failed.
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    // Membuat string query untuk select all from user
                    String query = "SELECT * FROM user";
                    // Membuat statement baru
                    Statement statement = connection.createStatement();
                    // Deklarasi result set untuk mengeksekusi query sebelumnya
                    ResultSet result = statement.executeQuery(query);
                    // Akan result next dalam baris database untuk mencari email
                    while (result.next()) {
                        System.out.println(result.getString("email"));
                    }
                } catch (SQLException e) {
                    // Jika gagal, akan print tersebut
                    System.out.println("Query failed: " + e.getMessage());
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println("Cannot close the connection: " + e.getMessage());
                    }
                }
            }
        }
    }
}