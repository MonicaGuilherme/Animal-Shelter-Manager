package shelter.models;

/**
 * Represents a generic animal in the shelter.
 * This class stores common data shared by all animals.
 */
public abstract class Animal {

        private int id;
        private Species species;
        private String name;
        private String sex;
        private String size;
        private boolean chip;
        private boolean vaccines;
        private boolean sterilized;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Species getSpecies() {
                return species;
        }

        public void setSpecies(Species species) {
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

        public boolean hasChip() {
                return chip;
        }

        public void setChip(boolean chip) {
                this.chip = chip;
        }

        public boolean hasVaccines() {
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
}