package torpedo.model;

import java.util.Scanner;

/**
 * This is the shooter class.
 *
 * @author Palla Gergely
 */

public class ShootMap {

    /**
     * Create random shooting coordinate (for Ai).
     *
     * @return the coordinate.
     */

    public static int[] randShootTest(int size, char[][] table) {
        int cordX;
        int cordY;
        int[] cord = {0, 0, 0, 0};

        cord[0] = ( int ) (Math.random() * size);
        cord[1] = ( int ) (Math.random() * size);

        if (table[cord[0]][cord[1]] == 'X') {
            cord[2] = 0;
        } else {
            cord[2] = 1;
        }

        return cord;
    }

    /**
     * Ask coordinate from the player for shooting.
     *
     * @return the coordinate.
     */

    public static int[] playerShootTest(int size, char[][] tablea, char[][] tableb, char[][] tablec) {
        char[] bet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int cordY = 0;
        char betu;
        Draw.drawTwoMap(size, tablea, tableb);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nKérem adja meg a hajó kordinatait \t [pl.: A1 vagy f20]");
        String cordi = scanner.nextLine();
        betu = Character.toUpperCase(cordi.charAt(0));
        for (int k = 0; k < size; k++) {
            if (bet[k] == betu) {
                cordY = k;
            }
        }
        int cordX = 0;
        cordi = cordi.substring(1);
        cordX = Integer.parseInt(cordi) - 1;
        int[] cord = {0, 0, 0, 0};
        cord[0] = cordX;
        cord[1] = cordY;
        if (tableb[cord[0]][cord[1]] == 'X') {
            cord[2] = 0;
        } else {
            System.out.println("\nAz érintett koordinátán \"" + tablec[cord[0]][cord[1]] + "\" található");
            cord[2] = 1;
        }
        return cord;
    }

    /**
     * Make X on the map.
     *
     * @return the map table.
     */

    public static char[][] shoot(int[] cord, char[][] table) {
        table[cord[0]][cord[1]] = 'X';
        return table;
    }

    /**
     * Make X on the map (or h or m).
     *
     * @return the map table.
     */

    public static char[][] playershoot(int[] cord, char[][] tablea, char[][] tableb) {
        if (tableb[cord[0]][cord[1]] == ' ') {
            tablea[cord[0]][cord[1]] = 'X';
        } else {
            tablea[cord[0]][cord[1]] = tableb[cord[0]][cord[1]];
        }
        return tablea;
    }
}
