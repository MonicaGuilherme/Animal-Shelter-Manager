package shelter;

import shelter.database.TableInitializer;

public class Main {

    public static void main(String[] args) {

/**
 * Entry point used to test DB connection and create tables.
 */
                System.out.println("Starting database initialization...");
                TableInitializer.initialize();
                System.out.println("Done.");

    }
}


