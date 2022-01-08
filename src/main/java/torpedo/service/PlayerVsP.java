package torpedo.service;

import torpedo.model.Draw;
import torpedo.model.ShipMap;
import torpedo.model.ShootMap;

/**
 * This is the Player vs. Player class.
 *
 * @author Palla Gergely
 */

public class PlayerVsP {

    public char [][] plshipfirstmap;
    public char [][] plshipseconmap;
    public char [][] plshootfirstmap;
    public char [][] plshootseconmap;

    public PlayerVsP(char [][] plshipfirstmap, char [][] plshipseconmap, char [][] plshootfirstmap, char [][] plshootseconmap) {
        this.plshipfirstmap = plshipfirstmap;
        this.plshipseconmap = plshipseconmap;
        this.plshootfirstmap = plshootfirstmap;
        this.plshootseconmap = plshootseconmap;
    }

    /**
     * the game itself (Player vs. Player).
     *
     */

    public static void start(int length, String gamerOne, String gamerTwo) {

        PlayerVsP maps = newDetails(length);
        System.out.println("\n" + gamerOne + " helyezzefel a hajókat a térképre!");
        maps.plshipfirstmap = ShipMap.playerShip(length, maps.plshipfirstmap);
        System.out.println("\n" + gamerTwo + " helyezzefel a hajókat a térképre!");
        maps.plshipseconmap = ShipMap.playerShip(length, maps.plshipseconmap);
        int [] cord;
        do {
            do {
                System.out.println("\n" + gamerOne + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipfirstmap, maps.plshootseconmap, maps.plshipseconmap);
            } while (cord[2] != 1);
            maps.plshootseconmap = ShootMap.playershoot(cord, maps.plshootseconmap, maps.plshipseconmap);
            maps.plshipseconmap = ShootMap.shoot(cord, maps.plshipseconmap);
            do {
                System.out.println("\n" + gamerTwo + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipseconmap, maps.plshootfirstmap, maps.plshipfirstmap);
            } while (cord[2] != 1);
            maps.plshootfirstmap = ShootMap.playershoot(cord, maps.plshootfirstmap, maps.plshipfirstmap);
            maps.plshipfirstmap = ShootMap.shoot(cord, maps.plshipfirstmap);

            cord = End.end(cord, length, maps.plshipfirstmap);
            cord = End.end(cord, length, maps.plshipseconmap);

        } while (cord[2] < 2);

        Draw.drawTwoMap(length, maps.plshipfirstmap, maps.plshipseconmap);

        if (cord[2] == 3) {
            System.out.println("\n\n" + gamerTwo + " nyerte a játékot, Gratulállok!");
            //            DataBase.endgame(gamerOne, false, false);
            //            DataBase.endgame(gamerTwo, true, false);
        } else if (cord[2] == 4) {
            System.out.println("\n\n" + gamerOne + " nyerte a játékot, Gratulállok!");
            //            DataBase.endgame(gamerOne, true, false);
            //            DataBase.endgame(gamerTwo, false, false);
        } else if (cord[2] == 5) {
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
            //            DataBase.endgame(gamerOne, false, true);
            //            DataBase.endgame(gamerTwo, false, true);
        }
    }

    /**
     * This is for the Player vs. Player object class.
     *
     * @return for the object.
     */

    public static PlayerVsP newDetails(int length) {
        char [][] plshipfirstmap;
        plshipfirstmap = ShipMap.createMap(length);
        char [][] plshipseconmap;
        plshipseconmap = ShipMap.createMap(length);
        char [][] plshootfirstmap;
        plshootfirstmap = ShipMap.createMap(length);
        char [][] plshootseconmap;
        plshootseconmap = ShipMap.createMap(length);

        return new PlayerVsP(plshipfirstmap, plshipseconmap, plshootfirstmap, plshootseconmap);
    }
}