package torpedo.service;

/**
 * This is the end game class.
 *
 * @author Palla Gergely
 */

public class End {

    /**
     * At the end of each round the machine checks if the game is over.
     *
     * @return the game is over? and who win or draw.
     */

    public static int[] end(int[] cord, int size, char[][] table) {
        if (cord[2] == 3) {
            cord[2] = 5;
        } else {
            cord[2] = 3;
        }
        int emt = 0;
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (table[i][k] == 'h') {
                    if (cord[2] == 5) {
                        cord[2] = 4;
                    } else if (cord[2] == 4) {
                        emt++;
                    } else {
                        cord[2] = 0;
                    }
                }
            }
        }
        return cord;
    }
}
