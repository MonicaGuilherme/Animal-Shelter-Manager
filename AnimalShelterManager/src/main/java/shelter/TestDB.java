package shelter;

import shelter.database.DatabaseManager;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DatabaseManager.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connection to SQLite established!");
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to connect: " + e.getMessage());
        }
    }
}
