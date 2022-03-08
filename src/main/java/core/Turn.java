package core;

import java.util.Random;
import java.util.Scanner;

public class Turn {
   public static void turnHuman(char[][] table) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!Cheks.isCellValid(table, x, y));
        table[y][x] = 'x';
    }

  public static void turnAI(char[][] table) {
        int x, y;
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!Cheks.isCellValid(table, x, y));
        table[y][x] = 'o';
    }
}
