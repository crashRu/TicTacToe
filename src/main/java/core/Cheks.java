package core;

public class Cheks {

    public static boolean isCellValid(char[][] table, int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            System.out.println("The move is wrong");
            return false;
        }
        return table[y][x] == '-';
    }

    public static boolean checkWin(char dot, char[][] table) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot)) {
                return true;
            }
        }
        if ((table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot)) {
            return true;
        }
        return false;
    }

    public static boolean isTableFull(char[][] table) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
