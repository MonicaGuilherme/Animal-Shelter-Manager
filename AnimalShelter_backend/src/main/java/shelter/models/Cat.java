package shelter.models;

/**
 * Represents a cat in the shelter.
 */
public class Cat extends Animal {

    private CatBreed breed;

    public CatBreed getBreed() {
        return breed;
    }

    public void setBreed(CatBreed breed) {
        this.breed = breed;
    }
}
