package Torpedo.service;

import java.util.Scanner;

class Obja {

    public String gamerOne;
    public String gamerTwo;
    public int size;
    public int gamernumb;

    public Obja (String gamerOne, String gamerTwo, int size, int gamernumb) {
        this.gamerOne = gamerOne;
        this.gamerTwo = gamerTwo;
        this.size = size;
        this.gamernumb = gamernumb;
    }
}

public class Start {

    public static void start() {

        Obja game = newDetails();

        switch (game.gamernumb) {
            case 0:
                AiVsAi.start(game.size);
                break;
            case 1:
                AiVsP.start(game.size, game.gamerOne);
                break;
            case 2:
                PlayerVsP.start(game.size, game.gamerOne, game.gamerTwo);
                break;
        }
    }

    public static Obja newDetails()
    {
        int size;
        int gamernumb;
        String gamerOne;
        String gamerTwo;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nPálya mérete számmal? (10 esetén 10*10) [2 - 26]");
        size = scanner.nextInt();
        if (size > 26 || size < 2){
            throw new IllegalStateException("Unexpected value: Pálya mérete");
        }

        System.out.println("\n\nJátékosok száma? [0 - 2]");
        gamernumb = scanner.nextInt();

        switch (gamernumb) {
            case 0:
                gamerOne = "AI1";
                gamerTwo = "AI2";
                break;
            case 1:
                System.out.println("\n\n1. Játékos neve?");
                gamerOne = scanner.nextLine();
                gamerTwo = "AI1";
                break;
            case 2:
                System.out.println("\n\n1. Játékos neve?");
                gamerOne = scanner.nextLine();
                System.out.println("\n\n2. Játékos neve?");
                gamerTwo = scanner.nextLine();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gamernumb);
        }

        return new Obja(gamerOne, gamerTwo, size, gamernumb);
    }
}