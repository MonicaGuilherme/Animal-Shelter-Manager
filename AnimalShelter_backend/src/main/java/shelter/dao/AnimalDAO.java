package shelter.dao;


import shelter.database.DatabaseManager;
import shelter.models.Animal;
import shelter.models.Cat;
import shelter.models.Dog;

import java.sql.*;
import java.util.List;

/**
 * Handles database operations for animals.
 */
public class AnimalDAO {

    /**
     * Saves an animal in the database.
     */
    public void save(Animal animal) {

        String sql = """
                INSERT INTO animal
                (species, breed, name, sex, size, chip, vaccines, sterilized)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animal.getSpecies().name());
            ps.setString(2, getBreed(animal));
            ps.setString(3, animal.getName());
            ps.setString(4, animal.getSex());
            ps.setString(5, animal.getSize());
            ps.setBoolean(6, animal.hasChip());
            ps.setBoolean(7, animal.hasVaccines());
            ps.setBoolean(8, animal.isSterilized());

            ps.executeUpdate();

            System.out.println("Animal saved successfully.");

        } catch (SQLException e) {
            System.err.println("Failed to save animal.");
            e.printStackTrace();
        }
    }

    /**
     * Gets the correct breed depending on the animal type.
     */
    private String getBreed(Animal animal) {

        if (animal instanceof Cat cat) {
            return cat.getBreed().name();
        }

        if (animal instanceof Dog dog) {
            return dog.getBreed().name();
        }

        throw new IllegalArgumentException("Unsupported animal type.");
    }

    public void findAll() {

        String sql = """
            SELECT * FROM animal;
            """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String species = rs.getString("species");
                String breed = rs.getString("breed");
                String name = rs.getString("name");

                System.out.println(id + " | " + species + " | " + breed + " | " + name);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

