package core;

public class InAndOutTable {
    static char[][] initTable(char [][] table) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = '-';

            }
        }
        return table;
    }

   static void printTable(char [][] table) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }
}
