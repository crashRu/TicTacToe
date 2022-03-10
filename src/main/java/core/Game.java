package core;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    char table[][] = new char[3][3];

    public static boolean rsl = true;

    public void game() throws IOException {
        String playerNameOne = Turn.getName("Player One");
        System.out.println("Если хотите сыграть с роботом напишите AI" +
                "\nЕсли хотите остановить игру введите Stop");
        String playerNameTwo = Turn.getName("Player Two");
        String win = " - Win!!!";
        table = InAndOutTable.initTable(table);
        do {
            Turn.turnHuman(table, 'x');
            if (Cheks.checkWin(SIGN_X, table)) {
                Write.write(playerNameOne + win);
                table = InAndOutTable.initTable(table);
                System.out.println(playerNameOne + win);
                continue;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                table = InAndOutTable.initTable(table);
                continue;
            }
            Turn.turnAI(table, playerNameTwo);
            InAndOutTable.printTable(table);
            if (Cheks.checkWin(SIGN_O, table)) {
                Write.write(playerNameTwo + win);
                table = InAndOutTable.initTable(table);
                System.out.println(playerNameTwo + win);
                continue;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                continue;
            }
        } while (isProceed());
    }

    public static boolean isProceed() {
        boolean rsl = Game.rsl;
        return rsl;
    }
}
