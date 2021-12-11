package Torpedo;

import Torpedo.service.Start;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean games;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Szeretne inditani egy új játékot?  [i] \nVagy betöltene egy korábbi állást? [load] \nVagy kilépni?                      [minden egyéb billentyű]");
            String ngame = scanner.nextLine();
            if (ngame.equals("i")) {
                Start.start();
                games = true;
            }
            else if (ngame.equals("load")) {
                System.out.println("állás betöltése");
                games = true;
            }
            else {
                games = false;
            }
        } while (games == true);
    }
}