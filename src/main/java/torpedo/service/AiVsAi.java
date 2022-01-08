package torpedo.service;

import torpedo.model.Draw;
import torpedo.model.ShipMap;
import torpedo.model.ShootMap;

/**
 * This is the Ai vs. Ai class.
 *
 * @author Palla Gergely
 */

public class AiVsAi {

    public char [][] aishipfirstmap;
    public char [][] aishipseconmap;
    public char [][] aishootfirstmap;
    public char [][] aishootseconmap;

    public AiVsAi(char [][] aishipfirstmap, char [][] aishipseconmap, char [][] aishootfirstmap, char [][] aishootseconmap) {
        this.aishipfirstmap = aishipfirstmap;
        this.aishipseconmap = aishipseconmap;
        this.aishootfirstmap = aishootfirstmap;
        this.aishootseconmap = aishootseconmap;
    }

    /**
     * the game itself (Ai vs. Ai).
     *
     */

    public static void start(int length) {

        int [] cord;

        AiVsAi maps = newDetails(length);

        maps.aishipfirstmap = ShipMap.randShip(length, maps.aishipfirstmap);
        maps.aishipseconmap = ShipMap.randShip(length, maps.aishipseconmap);

        do {
            do {
                cord = ShootMap.randShootTest(length, maps.aishipfirstmap);
            } while (cord[2] != 1);
            maps.aishipfirstmap = ShootMap.shoot(cord, maps.aishipfirstmap);
            maps.aishootseconmap = ShootMap.shoot(cord, maps.aishootseconmap);
            do {
                cord = ShootMap.randShootTest(length, maps.aishipseconmap);
            } while (cord[2] != 1);
            maps.aishipseconmap = ShootMap.shoot(cord, maps.aishipseconmap);
            maps.aishootfirstmap = ShootMap.shoot(cord, maps.aishootfirstmap);

            cord = End.end(cord, length, maps.aishipfirstmap);
            cord = End.end(cord, length, maps.aishipseconmap);

        } while (cord[2] < 2);

        Draw.drawTwoMap(length, maps.aishipfirstmap, maps.aishipseconmap);

        if (cord[2] == 4) {
            System.out.println("\n\nElso szamu jatekos nyert!");
            //DataBase.endgame("Ai1", true, false);
            //DataBase.endgame("Ai2", false, false);
        } else if (cord[2] == 3) {
            System.out.println("\n\nMasodik szamu jatekos nyert!");
            //DataBase.endgame("Ai2", true, false);
            //DataBase.endgame("Ai1", false, false);
        } else if (cord[2] == 5) {
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
            //DataBase.endgame("Ai1", false, true);
            //DataBase.endgame("Ai2", false, true);
        }
    }

    /**
     * This is for the Ai vs. Ai object class.
     *
     * @return for the object.
     */

    public static AiVsAi newDetails(int length) {
        char [][] aishipfirstmap;
        aishipfirstmap = ShipMap.createMap(length);
        char [][] aishipseconmap;
        aishipseconmap = ShipMap.createMap(length);
        char [][] aishootfirstmap;
        aishootfirstmap = ShipMap.createMap(length);
        char [][] aishootseconmap;
        aishootseconmap = ShipMap.createMap(length);

        return new AiVsAi(aishipfirstmap, aishipseconmap, aishootfirstmap, aishootseconmap);
    }
}
