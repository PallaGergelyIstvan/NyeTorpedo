package Torpedo.model;

import java.util.Scanner;

public class ShipMap {
    public static char[][] createMap (int size){
        char[][] table = new char[size][size];
        return table;
    }
    public static char[][] randShip (int size, char[][] table){
        int ship;
        int cordX;
        int cordY;
        int form;
        ship = size / 2;
        int i = 0;
        boolean nprob;
        do {
            nprob = true;
            cordX = (int)(Math.random() * size);
            cordY = (int)(Math.random() * size);
            form = (int)(Math.random() * 4);
            switch (form) {
                case 0:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordX + j <= size - 1){
                            if (table[cordX + j][cordY] != 'h' && table[cordX + j][cordY] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
                case 1:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordX - j >= 0){
                            if (table[cordX - j][cordY] != 'h' && table[cordX - j][cordY] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
                case 2:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordY + j <= size - 1){
                            if (table[cordX][cordY + j] != 'h' && table[cordX][cordY + j] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
                case 3:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordY - j >= 0){
                            if (table[cordX][cordY - j] != 'h' && table[cordX][cordY - j] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
            }
            if (nprob == true){
                switch (form) {
                    case 0:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX + j][cordY] = 'h';
                            if (cordX + j + 1 <= size - 1){if (table[cordX + j + 1][cordY] != 'h'){table[cordX + j + 1][cordY] = 'm';}}
                            if (cordX + j - 1 >= 0){if (table[cordX + j - 1][cordY] != 'h'){table[cordX + j - 1][cordY] = 'm';}}
                            if (cordY + 1 <= size - 1){if (table[cordX + j][cordY + 1] != 'h'){table[cordX + j][cordY + 1] = 'm';}}
                            if (cordY - 1 >= 0){if (table[cordX + j][cordY - 1] != 'h'){table[cordX + j][cordY - 1] = 'm';}}
                        }
                        break;
                    case 1:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX - j][cordY] = 'h';
                            if (cordX - j + 1 <= size - 1){if (table[cordX - j + 1][cordY] != 'h'){table[cordX - j + 1][cordY] = 'm';}}
                            if (cordX - j - 1 >= 0){if (table[cordX - j - 1][cordY] != 'h'){table[cordX - j - 1][cordY] = 'm';}}
                            if (cordY + 1 <= size - 1){if (table[cordX - j][cordY + 1] != 'h'){table[cordX - j][cordY + 1] = 'm';}}
                            if (cordY - 1 >= 0){if (table[cordX - j][cordY - 1] != 'h'){table[cordX - j][cordY - 1] = 'm';}}
                        }
                        break;
                    case 2:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX][cordY + j] = 'h';
                            if (cordX + 1 <= size - 1){if (table[cordX + 1][cordY + j] != 'h'){table[cordX + 1][cordY + j] = 'm';}}
                            if (cordX - 1 >= 0){if (table[cordX - 1][cordY + j] != 'h'){table[cordX - 1][cordY + j] = 'm';}}
                            if (cordY + j + 1 <= size - 1){if (table[cordX][cordY + j + 1] != 'h'){table[cordX][cordY + j + 1] = 'm';}}
                            if (cordY + j - 1 >= 0){if (table[cordX][cordY + j - 1] != 'h'){table[cordX][cordY + j - 1] = 'm';}}
                        }
                        break;
                    case 3:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX][cordY - j] = 'h';
                            if (cordX + 1 <= size - 1){if (table[cordX + 1][cordY - j] != 'h'){table[cordX + 1][cordY - j] = 'm';}}
                            if (cordX - 1 >= 0){if (table[cordX - 1][cordY - j] != 'h'){table[cordX - 1][cordY - j] = 'm';}}
                            if (cordY - j + 1 <= size - 1){if (table[cordX][cordY - j + 1] != 'h'){table[cordX][cordY - j + 1] = 'm';}}
                            if (cordY - j - 1 >= 0){if (table[cordX][cordY - j - 1] != 'h'){table[cordX][cordY - j - 1] = 'm';}}
                        }
                        break;
                }
                i++;
            }
        }while (i <= ship);
        return table;
    }

    public static char[][] playerShip (int size, char[][] table){
        int ship;
        int cordX = 0;
        int cordY = 0;
        int form;
        ship = size / 2;
        int i = 0;
        boolean nprob;
        char[] bet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char betu;
        do {
            nprob = true;
            Draw.drawOnlyMap(size, table);
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
            System.out.println("\nFekvő vagy álló hajót szeretne (fekvő jobbra tolodik, álló lefele tolodik) \t [F vagy A]");
            cordi = scanner.nextLine();
            betu = Character.toUpperCase(cordi.charAt(0));
            if (betu == 'F'){
                form = 0;
            }
            else {
                form = 2;
            }
            switch (form) {
                case 0:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordX + j <= size - 1){
                            if (table[cordX + j][cordY] != 'h' && table[cordX + j][cordY] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
                case 2:
                    for (int j = i; j < ship; j++)
                    {
                        if (cordY + j <= size - 1){
                            if (table[cordX][cordY + j] != 'h' && table[cordX][cordY + j] != 'm' ){ }
                            else{
                                nprob = false;
                            }
                        }
                        else{
                            nprob = false;
                        }
                    }
                    break;
            }
            if (nprob == true){
                switch (form) {
                    case 0:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX + j][cordY] = 'h';
                            if (cordX + j + 1 <= size - 1){if (table[cordX + j + 1][cordY] != 'h'){table[cordX + j + 1][cordY] = 'm';}}
                            if (cordX + j - 1 >= 0){if (table[cordX + j - 1][cordY] != 'h'){table[cordX + j - 1][cordY] = 'm';}}
                            if (cordY + 1 <= size - 1){if (table[cordX + j][cordY + 1] != 'h'){table[cordX + j][cordY + 1] = 'm';}}
                            if (cordY - 1 >= 0){if (table[cordX + j][cordY - 1] != 'h'){table[cordX + j][cordY - 1] = 'm';}}
                        }
                        break;
                    case 2:
                        for (int j = i; j < ship; j++)
                        {
                            table[cordX][cordY + j] = 'h';
                            if (cordX + 1 <= size - 1){if (table[cordX + 1][cordY + j] != 'h'){table[cordX + 1][cordY + j] = 'm';}}
                            if (cordX - 1 >= 0){if (table[cordX - 1][cordY + j] != 'h'){table[cordX - 1][cordY + j] = 'm';}}
                            if (cordY + j + 1 <= size - 1){if (table[cordX][cordY + j + 1] != 'h'){table[cordX][cordY + j + 1] = 'm';}}
                            if (cordY + j - 1 >= 0){if (table[cordX][cordY + j - 1] != 'h'){table[cordX][cordY + j - 1] = 'm';}}
                        }
                        break;
                }
                i++;
            }
            else{
                System.out.println("\nHibás Koordinátát adott meg.");
            }
        }while (i <= ship);
        return table;
    }
}