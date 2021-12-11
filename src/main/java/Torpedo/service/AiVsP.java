package Torpedo.service;

import Torpedo.model.Draw;
import Torpedo.model.ShipMap;
import Torpedo.model.ShootMap;

class Objc {

    public char [][] plshipfirstmap;
    public char [][] aishipseconmap;
    public char [][] aishootfirstmap;
    public char [][] plshootseconmap;

    public Objc (char [][] aishipfirstmap, char [][] aishipseconmap, char [][] aishootfirstmap, char [][] aishootseconmap) {
        this.plshipfirstmap = aishipfirstmap;
        this.aishipseconmap = aishipseconmap;
        this.aishootfirstmap = aishootfirstmap;
        this.plshootseconmap = aishootseconmap;
    }
}

public class AiVsP {
    public static void start(int length, String gamerOne) {

        int [] cord;

        Objc maps = newDetails(length);
        System.out.println("\nA " + gamerOne + " helyezzefel a hajókat a térképre!");
        maps.plshipfirstmap = ShipMap.playerShip(length, maps.plshipfirstmap);
        maps.aishipseconmap = ShipMap.randShip(length, maps.aishipseconmap);

        do {
            do {
                System.out.println("\nA " + gamerOne + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipfirstmap, maps.plshootseconmap, maps.aishipseconmap);
            }while(cord[2] != 1);
            maps.aishipseconmap = ShootMap.shoot(cord, maps.aishipseconmap);
            maps.plshootseconmap = ShootMap.shoot(cord, maps.plshootseconmap);
            do {
                cord = ShootMap.randShootTest(length, maps.plshipfirstmap);
            }while(cord[2] != 1);
            maps.plshipfirstmap = ShootMap.shoot(cord, maps.plshipfirstmap);
            maps.aishootfirstmap = ShootMap.shoot(cord, maps.aishootfirstmap);

            cord = End.end(cord, length, maps.plshipfirstmap);
            cord = End.end(cord, length, maps.aishipseconmap);

        }while(cord[2] < 2);

        Draw.drawTwoMap(length, maps.plshipfirstmap, maps.aishipseconmap);

        if(cord[2] == 3){
            System.out.println("\n\nGépi játékos nyert!");
        }
        else if(cord[2] == 4){
            System.out.println("\n\n" + gamerOne + " nyerte a játékot, Gratulállok!");
        }
        else if(cord[2] == 5){
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
        }
    }

    public static Objc newDetails(int length)
    {
        char [][] aishipfirstmap;
        char [][] aishipseconmap;
        char [][] aishootfirstmap;
        char [][] aishootseconmap;
        aishipfirstmap = ShipMap.createMap(length);
        aishipseconmap = ShipMap.createMap(length);
        aishootfirstmap = ShipMap.createMap(length);
        aishootseconmap = ShipMap.createMap(length);

        return new Objc(aishipfirstmap, aishipseconmap, aishootfirstmap, aishootseconmap);
    }
}
