package shelter.models;

/**
 * Represents a dog in the shelter.
 */
public class Dog extends Animal {

    private DogBreed breed;

    public DogBreed getBreed() {
        return breed;
    }

    public void setBreed(DogBreed breed) {
        this.breed = breed;
    }
}
