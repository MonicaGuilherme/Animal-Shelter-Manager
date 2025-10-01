package shelter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles database connections for the shelter system.
 * Uses SQLite (local file-based database).
 */
public class DatabaseManager {

    // Path to the SQLite database file
    private static final String DB_URL = "jdbc:sqlite:shelter.db";

    /**
     * Loads the SQLite JDBC driver (optional for newer versions but kept for clarity).
     */
    static {
        try {
            Class.forName("org.sqlite.JDBC"); // Load the driver
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found. Did you add the JAR to /lib?");
            e.printStackTrace();
        }
    }

    /**
     * Returns a connection to the database.
     * Remember: Caller must close the connection after use.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
