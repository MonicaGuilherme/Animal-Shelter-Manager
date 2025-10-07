package shelter;

import shelter.database.TableInitializer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Animal Shelter Manager... a small start!!");

        TableInitializer.initialize();

        System.out.println("Shelter system started.");



    }
}
