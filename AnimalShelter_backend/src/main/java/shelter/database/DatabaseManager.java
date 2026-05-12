package shelter.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Handles database configuration and connections.
 */
public class DatabaseManager {

    private static final Properties props = new Properties();

    static {

        try (InputStream input = DatabaseManager.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties file not found.");
            }

            props.load(input);

            String driver = props.getProperty("db.driver");

            if (driver != null && !driver.isEmpty()) {
                Class.forName(driver);
            }

        } catch (IOException | ClassNotFoundException e) {

            throw new RuntimeException("Failed to load database configuration.", e);
        }
    }

    /**
     * Creates and returns a new database connection.
     */
    public static Connection getConnection() throws SQLException {

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}