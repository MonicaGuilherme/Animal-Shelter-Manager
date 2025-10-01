package shelter.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Initializes database tables if they do not exist.
 * This ensures the schema is ready for use.
 */
public class TableInitializer {

    /**
     * Creates the animals table if it does not exist yet.
     */
    public static void initialize() {
        String sql = """
            CREATE TABLE IF NOT EXISTS animals (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                species TEXT NOT NULL,
                breed TEXT,
                age INTEGER,
                temperament TEXT,
                medical_history TEXT
            );
            """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✅ Animals table ready.");

        } catch (SQLException e) {
            System.err.println("❌ Failed to initialize tables: " + e.getMessage());
        }
    }
}
