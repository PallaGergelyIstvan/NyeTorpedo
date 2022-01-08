package torpedo.service;

import java.util.Scanner;

import torpedo.repository.DataBase;

/**
 * This is the start game class.
 *
 * @author Palla Gergely
 */

public class Game {

    public String gamerOne;
    public String gamerTwo;
    public int size;
    public int gamernumb;

    public Game(String gamerOne, String gamerTwo, int size, int gamernumb) {
        this.gamerOne = gamerOne;
        this.gamerTwo = gamerTwo;
        this.size = size;
        this.gamernumb = gamernumb;
    }

    /**
     * The game starts based on the number of players.
     *
     */

    public static void gamest() {

        Game game = newDetails();

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
            default:
        }
    }

    /**
     * The game ask the game details.
     *
     */

    public static Game newDetails() {
        int size;
        String gamerOne;
        String gamerTwo;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nPálya mérete számmal? (10 esetén 10*10) [2 - 26]");
        size = Integer.parseInt(scanner.nextLine());
        if (size > 26 || size < 2) {
            throw new IllegalStateException("Unexpected value: Pálya mérete");
        }

        System.out.println("\n\nJátékosok száma? [0 - 2]");
        int gamernumb;
        gamernumb = Integer.parseInt(scanner.nextLine());

        switch (gamernumb) {
            case 0:
                gamerOne = "AI1";
                gamerTwo = "AI2";
                break;
            case 1:
                System.out.println("\n\n1. Játékos neve?");
                gamerOne = scanner.nextLine();
                DataBase.newplayer(gamerOne);
                gamerTwo = "AI1";
                break;
            case 2:
                System.out.println("\n\n1. Játékos neve?");
                gamerOne = scanner.nextLine();
                DataBase.newplayer(gamerOne);
                System.out.println("\n\n2. Játékos neve?");
                gamerTwo = scanner.nextLine();
                DataBase.newplayer(gamerTwo);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gamernumb);
        }

        return new Game(gamerOne, gamerTwo, size, gamernumb);
    }
}