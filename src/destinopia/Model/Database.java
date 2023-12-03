package destinopia.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;   

public class Database {
    private Connection connection;

    public Database() {
        databaseConnection();
    }

    // DB Connection
    private void databaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/destinopia", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add data
    public void addData(String name, String password, String email) {
        try {
            String query = "INSERT INTO user (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Maybe add ID in here
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginCheck(String name, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Maybe add ID in here
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Session.setLoggedName(name);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void showData() {
        try {
            String query = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Name: " + resultSet.getString("username") + ", Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}