package torpedo.model;

/**
 * This is the draw class.
 *
 * @author Palla Gergely
 */

public class Draw {
    public static char[] bet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * Draw two map.
     *
     */

    public static void drawTwoMap(int size, char[][] tablea, char[][] tableb) {
        System.out.println("\n\n");
        System.out.print("\t");
        for (int i = 0; i < size; i++) {
            System.out.print(bet [i] + "\t");
        }
        System.out.print("\t\t\t");
        for (int i = 0; i < size; i++) {
            System.out.print(bet [i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "\t");
            for (int k = 0; k < size; k++) {
                System.out.print(tablea[i][k] + "\t");
            }
            System.out.print("\t\t" + (i + 1) + "\t");
            for (int k = 0; k < size; k++) {
                System.out.print(tableb[i][k] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Draw just one map.
     *
     */

    public static void drawOnlyMap(int size, char[][] table) {
        System.out.println("\n\n");
        System.out.print("\t");
        for (int i = 0; i < size; i++) {
            System.out.print(bet [i] + "\t");
        }
        System.out.print("\t\t\t");
        for (int i = 0; i < size; i++) {
            System.out.print(bet [i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "\t");
            for (int k = 0; k < size; k++) {
                System.out.print(table[i][k] + "\t");
            }
            System.out.println("");
        }
    }
}
