package Torpedo.service;

import Torpedo.model.Draw;
import Torpedo.model.ShipMap;
import Torpedo.model.ShootMap;

class Objb {

    public char [][] aishipfirstmap;
    public char [][] aishipseconmap;
    public char [][] aishootfirstmap;
    public char [][] aishootseconmap;

    public Objb (char [][] aishipfirstmap, char [][] aishipseconmap, char [][] aishootfirstmap, char [][] aishootseconmap) {
        this.aishipfirstmap = aishipfirstmap;
        this.aishipseconmap = aishipseconmap;
        this.aishootfirstmap = aishootfirstmap;
        this.aishootseconmap = aishootseconmap;
    }
}

public class AiVsAi {
    public static void start(int length) {

        int [] cord;

        Objb maps = newDetails(length);

        maps.aishipfirstmap = ShipMap.randShip(length, maps.aishipfirstmap);
        maps.aishipseconmap = ShipMap.randShip(length, maps.aishipseconmap);

        do {
            do {
                cord = ShootMap.randShootTest(length, maps.aishipfirstmap);
            }while(cord[2] != 1);
            maps.aishipfirstmap = ShootMap.shoot(cord, maps.aishipfirstmap);
            maps.aishootseconmap = ShootMap.shoot(cord, maps.aishootseconmap);
            do {
                cord = ShootMap.randShootTest(length, maps.aishipseconmap);
            }while(cord[2] != 1);
            maps.aishipseconmap = ShootMap.shoot(cord, maps.aishipseconmap);
            maps.aishootfirstmap = ShootMap.shoot(cord, maps.aishootfirstmap);

            cord = End.end(cord, length, maps.aishipfirstmap);
            cord = End.end(cord, length, maps.aishipseconmap);

        }while(cord[2] < 2);

        Draw.drawTwoMap(length, maps.aishipfirstmap, maps.aishipseconmap);

        if(cord[2] == 3){
            System.out.println("\n\nMásodik számú játékos nyert!");
        }
        else if(cord[2] == 4){
            System.out.println("\n\nElső számú játékos nyert!");
        }
        else if(cord[2] == 5){
            System.out.println("\n\nA játék döntetlen eredménnyel zárult!");
        }
    }

    public static Objb newDetails(int length)
    {
        char [][] aishipfirstmap;
        char [][] aishipseconmap;
        char [][] aishootfirstmap;
        char [][] aishootseconmap;
        aishipfirstmap = ShipMap.createMap(length);
        aishipseconmap = ShipMap.createMap(length);
        aishootfirstmap = ShipMap.createMap(length);
        aishootseconmap = ShipMap.createMap(length);

        return new Objb(aishipfirstmap, aishipseconmap, aishootfirstmap, aishootseconmap);
    }
}
