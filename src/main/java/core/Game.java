package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    char table[][] = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static List<String> winnerList = new ArrayList<>();

    public void game() throws IOException {
        System.out.println("Введите имя первого игрока");
        Player playerOne = new Player(scanner.nextLine(), SIGN_X);
        System.out.println("Введите имя второго игрока"
        + "\nЕсли хотите сыграть с ботом впишите AI");
        Player playerTwo = new Player(scanner.nextLine(), SIGN_O);
        table = InAndOutTable.initTable(table);
        do {
            System.out.println("Ход игрока: " + playerOne.getName());
            Turn.turnHuman(table, 'x', playerOne);
            if (Check.checkWin(SIGN_X, table)) {
                Write.write(playerOne.getWinName());
                winnerList.add(String.valueOf(playerOne.getId()));
                System.out.println(playerOne.getWinName());
                InAndOutTable.printTable(table);
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            if (Check.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                winnerList.add("DRAW!");
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            Turn.turnAI(table, playerTwo);
            InAndOutTable.printTable(table);
            if (Check.checkWin(SIGN_O, table)) {
                winnerList.add(String.valueOf(playerTwo.getId()));
                Write.write(playerTwo.getWinName());
                System.out.println(playerTwo.getWinName());
                InAndOutTable.printTable(table);
                if (isContinueGame()) {
                    break;
                }
                table = InAndOutTable.initTable(table);
                continue;
            }
            if (Check.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                if (isContinueGame()) {
                    break;
                }
                continue;
            }
        } while (true);
        OutputXMLFile.dom(playerOne, playerTwo);
    }

    public static boolean isContinueGame() {
        System.out.println("Хотите продолжить игру? Yes для продолжения No для остановки");
        return scanner.nextLine().equalsIgnoreCase("No");
    }

    public static List<String> getWinnerList() {
        return winnerList;
    }
}
