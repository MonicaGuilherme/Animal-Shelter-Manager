package shelter.dao;

import shelter.database.DatabaseManager;
import shelter.models.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles CRUD operations for the Animal table in the database.
 * Uses prepared statements to avoid SQL injection.
 */
public class AnimalDAO {

    /**
     * Inserts a new animal into the database.
     */
    public void addAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, species, breed, age, temperament, adopted) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getName());
            stmt.setString(2, animal.getSpecies());
            stmt.setString(3, animal.getBreed());
            stmt.setInt(4, animal.getAge());
            stmt.setString(5, animal.getTemperament());
            stmt.setBoolean(6, animal.isAdopted());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting animal: " + e.getMessage());
        }
    }

    /**
     * Retrieves all animals from the database.
     */
    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                animals.add(new Animal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("temperament"),
                        rs.getBoolean("adopted")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching animals: " + e.getMessage());
        }

        return animals;
    }
}
