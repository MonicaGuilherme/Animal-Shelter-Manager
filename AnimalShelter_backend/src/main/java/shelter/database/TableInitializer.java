package shelter.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TableInitializer
 * - Creates 'animal' table if it doesn't exist.
 * - Inserts two sample animals for initial data.
 */
public class TableInitializer {

    public static void initialize() {
        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);
            createAnimalTable(conn);
            insertSampleAnimals(conn);
            conn.commit();
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to initialize database: " + e.getMessage());
        }
    }

    private static void createAnimalTable(Connection conn) throws SQLException {
        String create = """
            CREATE TABLE IF NOT EXISTS animal (
                id SERIAL PRIMARY KEY,
                species TEXT NOT NULL,
                name TEXT NOT NULL,
                sex VARCHAR(10),
                size VARCHAR(20),
                chip BOOLEAN DEFAULT FALSE,
                vaccines BOOLEAN DEFAULT FALSE,
                sterilized BOOLEAN DEFAULT FALSE,
                type VARCHAR(20) NOT NULL CHECK (type IN ('Interno', 'Externo')),
                created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
            );
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(create);
            System.out.println("'animal' table ensured.");
        }
    }

    private static void insertSampleAnimals(Connection conn) throws SQLException {
        // check if table already has rows; if yes, skip inserting sample data
        try (Statement stmt = conn.createStatement();
             var rs = stmt.executeQuery("SELECT count(*) FROM animal")) {
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("Animal table already populated, skipping sample inserts.");
                return;
            }
        }

        String insert = """
            INSERT INTO animal (species, name, sex, size, chip, vaccines, sterilized, type)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
            """;

        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            // Sample 1: Cat
            ps.setString(1,"Cat");
            ps.setString(2, "Luna");
            ps.setString(3, "Female");
            ps.setString(4, "Small");
            ps.setBoolean(5, true); // chip
            ps.setBoolean(6, true);  // vaccines
            ps.setBoolean(7, true);  // sterilized
            ps.setString(8, "Externo");
            ps.executeUpdate();

            // Sample 2: Dog
            ps.setString(1, "Dog");
            ps.setString(2, "Max");
            ps.setString(3, "Male");
            ps.setString(4, "Medium");
            ps.setBoolean(5, false); // chip
            ps.setBoolean(6, false); // vaccines
            ps.setBoolean(7, false); // sterilized
            ps.setString(8, "Interno");
            ps.executeUpdate();

            System.out.println("Inserted 2 sample animals.");
        }
    }
}



































