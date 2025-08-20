package shelter.services;

import shelter.dao.AnimalDAO;
import shelter.models.Animal;

import java.util.List;

/**
 * Business layer for handling Animal-related operations.
 * Keeps controllers and DAOs separated.
 */
public class AnimalService {
    private AnimalDAO animalDAO;

    public AnimalService() {
        this.animalDAO = new AnimalDAO();
    }

    public void addAnimal(Animal animal) {
        animalDAO.addAnimal(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }
}
