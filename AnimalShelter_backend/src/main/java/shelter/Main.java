package shelter;

import shelter.dao.AnimalDAO;
import shelter.database.TableInitializer;
import shelter.models.*;

public class Main {

    public static void main(String[] args) {

/**
 * Entry point used to test DB connection and create tables.
 */
                System.out.println("Starting database initialization...");
                TableInitializer.initialize();
                System.out.println("Done.");


                AnimalDAO animalDAO = new AnimalDAO();

                Cat cat = new Cat();
                cat.setSpecies(Species.CAT);
                cat.setBreed(CatBreed.SIAMESE);
                cat.setName("Luna");
                cat.setSex("Female");
                cat.setSize("Small");
                cat.setChip(true);
                cat.setVaccines(true);
                cat.setSterilized(true);

                Dog dog = new Dog();
                dog.setSpecies(Species.DOG);
                dog.setBreed(DogBreed.LABRADOR);
                dog.setName("Max");
                dog.setSex("Male");
                dog.setSize("Medium");
                dog.setChip(false);
                dog.setVaccines(false);
                dog.setSterilized(false);

                animalDAO.save(cat);
                animalDAO.save(dog);
            }
        }




