package nye.harmadikfélév.torpedo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adja meg az 1-es játékos nevét:");
        Gamer gamer = new Gamer(scanner.nextLine());
        System.out.println("Név:" + gamer.getName());
        System.out.println("Kérem adja meg a játékosok számát (1 vagy 2):");
        String info = (scanner.nextLine());
        if (info.equals("1")) {}
        else if (info.equals("2")){throw new IllegalArgumentException("Nincs megírva több játékosra a program!");}
        else {throw new IllegalArgumentException("Nem valós értékű játékos szám!");}
        System.out.println("Név:" + gamer.getName());
    }
}
