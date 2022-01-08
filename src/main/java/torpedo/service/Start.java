package torpedo.service;

import java.util.Scanner;

import torpedo.repository.DataBase;

/**
 * This is the start game class.
 *
 * @author Palla Gergely
 */

public class Start {

    /**
     * The game starts.
     *
     */

    void start() {
        boolean games;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Szeretne inditani egy új játékot?  [i] \nVagy " +
                    "betöltene egy korábbi állást? [load] \nVagy " +
                    "kilépni?                      [minden egyéb billentyű]");
            String ngame = scanner.nextLine();
            if (ngame.equals("i")) {
                Game.gamest();
                games = true;
            } else if (ngame.equals("load")) {
                System.out.println("állás betöltése");
                games = true;
            } else if (ngame.equals("config")) {
                System.out.println("Config start");
                DataBase.config();
                System.out.println("Game quit.");
                games = false;
            } else {
                games = false;
            }
        } while (games == true);
    }
}