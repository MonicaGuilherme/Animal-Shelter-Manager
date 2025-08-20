package shelter.controllers;

import shelter.models.Animal;
import shelter.services.AnimalService;

import java.util.List;

/**
 * Controller for managing Animal operations.
 * In a GUI app, this would be triggered by button clicks or forms.
 */
public class AnimalController {
    private AnimalService animalService;

    public AnimalController() {
        this.animalService = new AnimalService();
    }

    public void addNewAnimal(String name, String species, String breed, int age, String temperament, boolean adopted) {
        Animal animal = new Animal(name, species, breed, age, temperament, adopted);
        animalService.addAnimal(animal);
    }

    public void listAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
