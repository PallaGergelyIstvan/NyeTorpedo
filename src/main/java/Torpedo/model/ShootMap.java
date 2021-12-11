package Torpedo.model;

import java.util.Scanner;

public class ShootMap {
    public static int[] randShootTest (int size, char[][] table){
        int cordX;
        int cordY;
        int[] cord = {0, 0, 0, 0};

        cord[0] = (int)(Math.random() * size);
        cord[1] = (int)(Math.random() * size);

        if (table[cord[0]][cord[1]] == 'X'){
            cord[2] = 0;
        }
        else{
            cord[2] = 1;
        }

        return cord;
    }

    public static int[] playerShootTest (int size, char[][] tablea, char[][] tableb, char[][] tablec){
        char[] bet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int cordX;
        int cordY;
        char betu;
        int[] cord = {0, 0, 0, 0};
        Draw.drawTwoMap(size, tablea, tableb);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nKérem adja meg a hajó kordinatait \t [pl.: A1 vagy f20]");
        String cordi = scanner.nextLine();
        betu = Character.toUpperCase(cordi.charAt(0));
        for (int k = 0; k < size; k++)
        {
            if (bet[k] == betu) {
                cordX = k;
            }
        }
        cordi = cordi.substring(1);
        cordY = Integer.parseInt(cordi) - 1;

        cord[0] = (int)(Math.random() * size);
        cord[1] = (int)(Math.random() * size);

        if (tableb[cord[0]][cord[1]] == 'X'){
            cord[2] = 0;
        }
        else{
            System.out.println("\nAz érintett koordinátán " + shootTarget(cord, tablec) + " található");
            cord[2] = 1;
        }

        return cord;
    }

    public static char shootTarget (int[] cord, char[][] table){
        return table[cord[0]][cord[1]];
    }

    public static char[][] shoot (int[] cord, char[][] table){
        table[cord[0]][cord[1]] = 'X';
        return table;
    }

}
