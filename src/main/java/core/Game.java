package core;
import java.io.IOException;

public class Game {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    char table[][] = new char[3][3];

    public void game() throws IOException {
        String playerWin = "Player Win!";
        String aiWin = "AI WIN";
        table = InAndOutTable.initTable(table);
        while (true) {
           Turn.turnHuman(table);
            if (Cheks.checkWin(SIGN_X, table)) {
                Write.write(playerWin);
                System.out.println(playerWin);
                break;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            Turn.turnAI(table);
            InAndOutTable.printTable(table);
            if (Cheks.checkWin(SIGN_O, table)) {
                Write.write(aiWin);
                System.out.println(aiWin);
                break;
            }
            if (Cheks.isTableFull(table)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        InAndOutTable.printTable(table);
    }


}
