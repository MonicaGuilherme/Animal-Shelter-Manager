package shelter.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DatabaseManager
 * - Responsible for reading DB configuration from resources/db.properties
 * - Provides a Connection to the PostgreSQL database.
 */
public class DatabaseManager {

    private static final Properties props = new Properties();

    static {
        try (InputStream in = DatabaseManager.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new RuntimeException("db.properties not found in classpath. Copy db.properties.example to db.properties and fill in credentials.");
            }
            props.load(in);
            // Explicitly loads the JDBC driver class if specified in the configuration properties.
            // Ensures compatibility with older drivers or environments where auto-registration may fail.
            // This precaution helps prevent runtime connection issues and guarantees that the driver is available when initializing the database connection.
            String driver = props.getProperty("db.driver");
            if (driver != null && !driver.isEmpty()) {
                Class.forName(driver);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database properties or driver: " + e.getMessage());
        }
    }

    /**
     * Obtain a new Connection using properties from db.properties.
     * Caller should close the connection.
     */
    public static Connection getConnection() throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}

