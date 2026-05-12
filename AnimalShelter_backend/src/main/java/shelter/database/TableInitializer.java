package shelter.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates the database tables needed by the application.
 */
public class TableInitializer {

    public static void initialize() {

        try (Connection conn = DatabaseManager.getConnection()) {

            createAnimalTable(conn);
            insertSampleAnimals(conn);

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {

            System.err.println("Failed to initialize database.");
            e.printStackTrace();
        }
    }

    /**
     * Creates the animal table if it does not already exist.
     */
    private static void createAnimalTable(Connection conn) throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS animal (
                id SERIAL PRIMARY KEY,
                species VARCHAR(20) NOT NULL,
                breed VARCHAR(50) NOT NULL,
                name VARCHAR(100) NOT NULL,
                sex VARCHAR(10) NOT NULL,
                size VARCHAR(20) NOT NULL,
                chip BOOLEAN DEFAULT FALSE,
                vaccines BOOLEAN DEFAULT FALSE,
                sterilized BOOLEAN DEFAULT FALSE,
                created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
            );
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Animal table ready.");
        }
    }

    /**
     * Inserts sample animals only if the table is empty.
     */
    private static void insertSampleAnimals(Connection conn) throws SQLException {

        if (animalTableHasData(conn)) {
            System.out.println("Animal table already has data. Skipping sample inserts.");
            return;
        }

        String sql = """
            INSERT INTO animal 
            (species, breed, name, sex, size, chip, vaccines, sterilized)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // Sample cat
            ps.setString(1, "CAT");
            ps.setString(2, "SIAMESE");
            ps.setString(3, "Luna");
            ps.setString(4, "Female");
            ps.setString(5, "Small");
            ps.setBoolean(6, true);
            ps.setBoolean(7, true);
            ps.setBoolean(8, true);
            ps.executeUpdate();

            // Sample dog
            ps.setString(1, "DOG");
            ps.setString(2, "LABRADOR");
            ps.setString(3, "Max");
            ps.setString(4, "Male");
            ps.setString(5, "Medium");
            ps.setBoolean(6, false);
            ps.setBoolean(7, false);
            ps.setBoolean(8, false);
            ps.executeUpdate();

            System.out.println("Inserted sample animals.");
        }
    }

    /**
     * Checks if the animal table already contains records.
     */
    private static boolean animalTableHasData(Connection conn) throws SQLException {

        String sql = "SELECT COUNT(*) FROM animal";

        try (Statement stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {

            rs.next();
            return rs.getInt(1) > 0;
        }
    }
}



































