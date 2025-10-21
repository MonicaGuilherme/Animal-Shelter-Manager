package shelter.models;



/**
 * Represents an animal in the shelter.
 * This class only holds data — no business logic here.
 */
public class Animal {

        private int id;
        private String species;
        private String name;
        private String sex;
        private String size;
        private boolean chip;
        private boolean vaccines;
        private boolean sterilized;
        private String type;

        // constructors, getters, setters
        public Animal() {}

        public Animal(String name, String sex, String size, boolean chip, boolean vaccines, boolean sterilized, String type) {
            this.name = name;
            this.sex = sex;
            this.size = size;
            this.chip = chip;
            this.vaccines = vaccines;
            this.sterilized = sterilized;
            this.type = type;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isChip() {
        return chip;
    }

    public void setChip(boolean chip) {
        this.chip = chip;
    }

    public boolean isVaccines() {
        return vaccines;
    }

    public void setVaccines(boolean vaccines) {
        this.vaccines = vaccines;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


