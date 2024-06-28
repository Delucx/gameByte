package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class crudBase {
private Connection connection;

public crudBase() {
    dbConnect();
}

public void dbConnect() {
    try {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        System.out.println("Found Driver");
        connection = DatabaseConnection.getConnection();
        System.out.println("Connected");
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println("Failed to connect to the database");
    }
}

    // Create operation
    public void createUser(int userNumber, String firstName, String lastName, String email, int contactNumber, String userName) throws SQLException {
        String sql = "INSERT INTO users (userNumber, firstName, lastName, email, contactNumber, userName) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userNumber);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setInt(5, contactNumber);
            statement.setString(6, userName);
            statement.executeUpdate();
        }
    }

    // Read all operation
    public ArrayList<Users> readAllUsers() throws SQLException {
        ArrayList<Users> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userNumber = resultSet.getInt("userNumber");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                int contactNumber = resultSet.getInt("contactNumber");
                String userName = resultSet.getString("userName");

                Users user = new Users(userNumber, firstName, lastName, email, contactNumber, userName);
                userList.add(user);
            }
        }
        return userList;
    }

    // Read operation
    public Users readUser(int userNumber) throws SQLException {
        String sql = "SELECT * FROM users WHERE userNumber = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                int contactNumber = resultSet.getInt("contactNumber");
                String userName = resultSet.getString("userName");

                return new Users(userNumber, firstName, lastName, email, contactNumber, userName);
            }
        }
        return null;
    }

    // Update operation
    public void updateUser(int userNumber, String firstName, String lastName, String email, int contactNumber, String userName) throws SQLException {
        String sql = "UPDATE users SET firstName = ?, lastName = ?, email = ?, contactNumber = ?, userName = ? WHERE userNumber = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, contactNumber);
            statement.setString(5, userName);
            statement.setInt(6, userNumber);
            statement.executeUpdate();
        }
    }

    // Delete operation
    public void deleteUser(int userNumber) throws SQLException {
        String sql = "DELETE FROM users WHERE userNumber = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userNumber);
            statement.executeUpdate();
        }
    }
}
