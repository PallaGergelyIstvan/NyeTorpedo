package Torpedo.service;

public class End {
    public static int[] end (int[] cord, int size, char[][] table){
        if (cord[2] == 3) {
            cord[2] = 5;
        }
        else {
            cord[2] = 3;
        }
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                if (table[i][k] == 'h')
                {
                    if (cord[2] == 5){
                        cord[2] = 4;
                    }
                    else if (cord[2] == 4) {}
                    else {
                        cord[2] = 0;
                    }
                }
            }
        }
        return cord;
    }
}
