package shelter.models;



/**
 * Represents an animal in the shelter.
 * This class only holds data — no business logic here.
 */
public class Animal {

    private int id;            // Unique ID
    private String name;       // Animal name
    private String species;    // Species (Dog or Cat)
    private String breed;      // Breed (specific breed of the animal)
    private int age;           // Age in years
    private String temperament; // Temperament description
    private boolean adopted;   // Whether the animal has been adopted

    public Animal(int id, String name, String species, String breed, int age, String temperament, boolean adopted) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.temperament = temperament;
        this.adopted = adopted;
    }

    // Constructor without ID (for new animals before saving to DB)
    public Animal(String name, String species, String breed, int age, String temperament, boolean adopted) {
        this(-1,name, species, breed, age, temperament, adopted);
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getTemperament() { return temperament; }
    public void setTemperament(String temperament) { this.temperament = temperament; }
    public boolean isAdopted() { return adopted; }
    public void setAdopted(boolean adopted) { this.adopted = adopted; }

}
