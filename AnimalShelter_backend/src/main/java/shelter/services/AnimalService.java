package shelter.services;

import shelter.dao.AnimalDAO;
import shelter.models.Animal;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Service layer that handles business logic for Animal entities.
 * Performs validation before delegating operations to the DAO.
 * Keeps controllers and DAOs separated.
 */
public class AnimalService {
    private final AnimalDAO dao = new AnimalDAO();

    /**
     * Creates a new animal record after validating input data.
     */
    public Animal createAnimal(Animal a) throws IllegalArgumentException, SQLException {
        validate(a, false);
        return dao.create(a);
    }

    /**
     * Retrieves an animal by its ID.
     * @throws NotFoundException if no animal is found with the given ID.
     */
    public Animal getAnimal(int id) throws NotFoundException, SQLException {
        Optional<Animal> op = dao.findById(id);
        return op.orElseThrow(() -> new NotFoundException("Animal not found: " + id));
    }

    /**
     * Returns a list of all animals in the database.
     */
    public List<Animal> listAnimals() throws SQLException {
        return dao.findAll();
    }

    /**
     * Updates an existing animal record after validation.
     * @throws NotFoundException if the animal does not exist.
     */
    public void updateAnimal(Animal a) throws NotFoundException, IllegalArgumentException, SQLException {
        validate(a, true);
        boolean ok = dao.update(a);
        if (!ok) throw new NotFoundException("Animal not found: " + a.getId());
    }

    /**
     * Deletes an animal by ID.
     * @throws NotFoundException if the animal does not exist.
     */
    public void deleteAnimal(int id) throws NotFoundException, SQLException {
        boolean ok = dao.delete(id);
        if (!ok) throw new NotFoundException("Animal not found: " + id);
    }

    /**
     * Validates animal data before create or update operations.
     * @param requireId true if the operation requires an existing ID (update).
     */
    private void validate(Animal a, boolean requireId) {
        if (requireId && a.getId() <= 0) {
            throw new IllegalArgumentException("id is required for update");
        }

        if (a.getSpecies() == null || a.getSpecies().trim().isEmpty()) {
            throw new IllegalArgumentException("species is required");
        }

        if (a.getName() == null || a.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }

        if (a.getSex() == null || a.getSex().trim().isEmpty()) {
            throw new IllegalArgumentException("sex is required");
        }

        if (a.getSize() == null || a.getSize().trim().isEmpty()) {
            throw new IllegalArgumentException("size is required");
        }

        if (a.getType() == null || a.getType().trim().isEmpty()) {
            throw new IllegalArgumentException("type is required");
        }

        // Check valid values for type
        if (!a.getType().equalsIgnoreCase("interno") && !a.getType().equalsIgnoreCase("externo")) {
            throw new IllegalArgumentException("type must be either 'interno' or 'externo'");
        }
    }

    /**
     * Simple custom exception for not found entities.
     */
    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String msg) {
            super(msg);
        }
    }
}
