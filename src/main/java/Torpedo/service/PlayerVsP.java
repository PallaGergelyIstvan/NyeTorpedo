package Torpedo.service;

import Torpedo.model.Draw;
import Torpedo.model.ShipMap;
import Torpedo.model.ShootMap;

class Objd {

    public char [][] plshipfirstmap;
    public char [][] plshipseconmap;
    public char [][] plshootfirstmap;
    public char [][] plshootseconmap;

    public Objd (char [][] aishipfirstmap, char [][] aishipseconmap, char [][] aishootfirstmap, char [][] aishootseconmap) {
        this.plshipfirstmap = aishipfirstmap;
        this.plshipseconmap = aishipseconmap;
        this.plshootfirstmap = aishootfirstmap;
        this.plshootseconmap = aishootseconmap;
    }
}

public class PlayerVsP {
    public static void start(int length, String gamerOne, String gamerTwo) {

        int [] cord;

        Objd maps = newDetails(length);
        System.out.println("\nA " + gamerOne + " helyezzefel a hajókat a térképre!");
        maps.plshipfirstmap = ShipMap.playerShip(length, maps.plshipfirstmap);
        System.out.println("\nA " + gamerTwo + " helyezzefel a hajókat a térképre!");
        maps.plshipseconmap = ShipMap.playerShip(length, maps.plshipseconmap);

        do {
            do {
                System.out.println("\nA " + gamerOne + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipfirstmap, maps.plshootseconmap, maps.plshipseconmap);
            }while(cord[2] != 1);
            maps.plshipseconmap = ShootMap.shoot(cord, maps.plshipseconmap);
            maps.plshootseconmap = ShootMap.shoot(cord, maps.plshootseconmap);
            do {
                System.out.println("\nA " + gamerTwo + " következik a lövéssel!");
                cord = ShootMap.playerShootTest(length, maps.plshipseconmap, maps.plshootfirstmap, maps.plshipfirstmap);
            }while(cord[2] != 1);
            maps.plshipfirstmap = ShootMap.shoot(cord, maps.plshipfirstmap);
            maps.plshootfirstmap = ShootMap.shoot(cord, maps.plshootfirstmap);

            cord = End.end(cord, length, maps.plshipfirstmap);
            cord = End.end(cord, length, maps.plshipseconmap);

        }while(cord[2] < 2);

        Draw.drawTwoMap(length, maps.plshipfirstmap, maps.plshipseconmap);

        if(cord[2] == 3){
            System.out.println("\n\n" + gamerTwo + " nyerte a játékot, Gratulállok!");
        }
        else if(cord[2] == 4){
            System.out.println("\n\n" + gamerOne + " nyerte a játékot, Gratulállok!");
        }
        else if(cord[2] == 5){
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
        }
    }

    public static Objd newDetails(int length)
    {
        char [][] aishipfirstmap;
        char [][] aishipseconmap;
        char [][] aishootfirstmap;
        char [][] aishootseconmap;
        aishipfirstmap = ShipMap.createMap(length);
        aishipseconmap = ShipMap.createMap(length);
        aishootfirstmap = ShipMap.createMap(length);
        aishootseconmap = ShipMap.createMap(length);

        return new Objd(aishipfirstmap, aishipseconmap, aishootfirstmap, aishootseconmap);
    }
}