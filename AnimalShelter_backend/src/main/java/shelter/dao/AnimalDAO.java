package shelter.dao;


import shelter.database.DatabaseManager;
import shelter.models.Animal;
import shelter.models.Cat;
import shelter.models.Dog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            //ps.executeUpdate();

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
}

