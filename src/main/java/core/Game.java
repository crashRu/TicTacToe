package core;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    char table[][] = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    public static boolean rsl = true;

    public void game() throws IOException {
        System.out.println("Введите имя первого игрока");
        Player playerOne = new Player(scanner.nextLine());
        System.out.println("Введите имя второго игрока"
        + "\nЕсли хотите сыграть с ботом впишите AI");
        Player playerTwo = new Player(scanner.nextLine());
        table = InAndOutTable.initTable(table);
        do {
            Turn.turnHuman(table, 'x');
            if (Cheks.checkWin(SIGN_X, table)) {
                Write.write(playerOne.getWinName());
                System.out.println(playerOne.getWinName());
                InAndOutTable.printTable(table);
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            Turn.turnAI(table, playerTwo);
            InAndOutTable.printTable(table);
            if (Cheks.checkWin(SIGN_O, table)) {
                Write.write(playerTwo.getWinName());
                System.out.println(playerTwo.getWinName());
                InAndOutTable.printTable(table);
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                if (isContinueGame()) {
                    break;
                }
                continue;
            }
        } while (true);
    }

    public static boolean isContinueGame() {
        System.out.println("Хотите продолжить игру? Yes для продолжения No для остановки");
        return scanner.nextLine().equalsIgnoreCase("No");
    }
}
