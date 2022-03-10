package core;

import java.util.Random;
import java.util.Scanner;

public class Turn {
    static Scanner scanner = new Scanner(System.in);
    public static void turnHuman(char[][] table, char symbol) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (x < 0 || y < 0) {
                Game.rsl = false;
                break;
            }
        } while (!Cheks.isCellValid(table, x, y));
        table[y][x] = symbol;
    }

    public static void turnAI(char[][] table, String playerNameTwo) {
        int x, y;
        if (playerNameTwo.equalsIgnoreCase("AI")) {
            Random random = new Random();
            do {
                x = random.nextInt(3);
                y = random.nextInt(3);
            } while (!Cheks.isCellValid(table, x, y));
            table[y][x] = 'o';
        }else {
            turnHuman(table, 'o');
        }
    }

    public static String getName(String player) {
        System.out.println("Введите имя: " + player);
        return scanner.nextLine();

    }
}
