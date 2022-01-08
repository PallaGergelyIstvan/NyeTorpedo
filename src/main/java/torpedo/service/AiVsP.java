package torpedo.service;

import torpedo.model.Draw;
import torpedo.model.ShipMap;
import torpedo.model.ShootMap;

/**
 * This is the Ai vs. Player class.
 *
 * @author Palla Gergely
 */

public class AiVsP {

    public char [][] plshipfirstmap;
    public char [][] aishipseconmap;
    public char [][] aishootfirstmap;
    public char [][] plshootseconmap;

    public AiVsP(char [][] plshipfirstmap, char [][] aishipseconmap, char [][] aishootfirstmap, char [][] plshootseconmap) {
        this.plshipfirstmap = plshipfirstmap;
        this.aishipseconmap = aishipseconmap;
        this.aishootfirstmap = aishootfirstmap;
        this.plshootseconmap = plshootseconmap;
    }

    /**
     * the game itself (Ai vs. Player).
     *
     */

    public static void start(int length, String gamerOne) {

        AiVsP maps = newDetails(length);
        System.out.println("\nA " + gamerOne + " helyezze fel a hajókat a térképre!");
        maps.plshipfirstmap = ShipMap.playerShip(length, maps.plshipfirstmap);
        maps.aishipseconmap = ShipMap.randShip(length, maps.aishipseconmap);
        int [] cord;
        System.out.println("\nA hajok felhelyezése megtörtént a térképre, kezdődjék a harc!");
        do {
            do {
                System.out.println("\n" + gamerOne + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipfirstmap, maps.plshootseconmap, maps.aishipseconmap);
            } while (cord[2] != 1);
            maps.plshootseconmap = ShootMap.playershoot(cord, maps.plshootseconmap, maps.aishipseconmap);
            maps.aishipseconmap = ShootMap.shoot(cord, maps.aishipseconmap);
            do {
                cord = ShootMap.randShootTest(length, maps.plshipfirstmap);
            } while (cord[2] != 1);
            maps.plshipfirstmap = ShootMap.shoot(cord, maps.plshipfirstmap);
            maps.aishootfirstmap = ShootMap.shoot(cord, maps.aishootfirstmap);

            cord = End.end(cord, length, maps.plshipfirstmap);
            cord = End.end(cord, length, maps.aishipseconmap);

        } while (cord[2] < 2);

        Draw.drawTwoMap(length, maps.plshipfirstmap, maps.aishipseconmap);

        if (cord[2] == 3) {
            System.out.println("\n\n" + gamerOne + " nyerte a játékot, Gratulállok!");
            //DataBase.endgame(gamerOne, true, false);
            //DataBase.endgame("Ai2", false, false);
        } else if (cord[2] == 4) {
            System.out.println("\n\nGépi játékos nyert!");
            //DataBase.endgame(gamerOne, false, false);
            //DataBase.endgame("Ai2", true, false);
        } else if (cord[2] == 5) {
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
            //DataBase.endgame(gamerOne, false, true);
            //DataBase.endgame("Ai2", false, true);
        }
    }

    /**
     * This is for the Ai vs. Player object class.
     *
     * @return for the object.
     */

    public static AiVsP newDetails(int length) {
        char [][] plshipfirstmap;
        plshipfirstmap = ShipMap.createMap(length);
        char [][] aishipseconmap;
        aishipseconmap = ShipMap.createMap(length);
        char [][] aishootfirstmap;
        aishootfirstmap = ShipMap.createMap(length);
        char [][] plshootseconmap;
        plshootseconmap = ShipMap.createMap(length);

        return new AiVsP(plshipfirstmap, aishipseconmap, aishootfirstmap, plshootseconmap);
    }
}
