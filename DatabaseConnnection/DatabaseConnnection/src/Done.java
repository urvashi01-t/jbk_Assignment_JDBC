import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Done {
    public static void main(String[] args) {
        // JDBC URL, username, and password of the database
        String jdbcURL = "jdbc:mysql://localhost:3306/Login";
        String username = "root";
        String password = "1234";

        try {
            // 1. Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // 2. Create a Statement object
            Statement statement = connection.createStatement();

            // 3. INSERT operation
            int id = 8; // Change this to the desired ID
            String usernameToInsert = "john_doe";
            String passwordToInsert = "my_password";
            String insertQuery = "INSERT INTO login12334 (idLogin, username, password) VALUES (" + id + ", '" + usernameToInsert + "', '" + passwordToInsert + "')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println(rowsInserted + " row(s) inserted.");

            // 4. SELECT operation
            String selectQuery = "SELECT * FROM login12334";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int userId = resultSet.getInt("idLogin");
                String userName = resultSet.getString("username");
                String userPassword = resultSet.getString("password");
                System.out.println("User ID: " + userId + ", Username: " + userName + ", Password: " + userPassword);
            }

            // 5. UPDATE operation
            String newPassword = "new_password"; // Change this to the desired new password
            String updateQuery = "UPDATE login12334 SET password = '" + newPassword + "' WHERE idLogin = " + id;
            int rowsUpdated = statement.executeUpdate(updateQuery);
            System.out.println(rowsUpdated + " row(s) updated.");

            // 6. DELETE operation
            id=3;
            String deleteQuery = "DELETE FROM login12334 WHERE idLogin = " + id;
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " row(s) deleted.");

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
