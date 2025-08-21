package shelter;

import shelter.database.TableInitializer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Animal Shelter Manager... a small start!!");

        TableInitializer.initialize();

        System.out.println("Shelter system started.");

       /*To do list:
        check - project base
        check (but bug from step 1.2.1 still persists _  Connection succeeds but logging messages are missing) - add library (SQLite or PostgresSQL - talk with the animal shelter) -- installed SQLite for the MVP, later switch to PostgresSQL
        check - config database
        check - create: models, daos. copntrollers,services

          - utils (aux functions)
        - UI (javascript,html,css - research electron)
        - testing
    * */

    }
}
