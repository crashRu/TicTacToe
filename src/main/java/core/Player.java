package core;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private static int iterator;
    private List<Integer> turnList = new ArrayList<>();
    private int id;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        setId();
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public char getSymbol() {
        return symbol;
    }

    private void setId() {
        id = iterator++;
    }

    public List<Integer> getTurnList() {
        return turnList;
    }

    public String getName() {
        return name;
    }

    public void setTurnList(int a) {
        if (a >= 0 && a < 9) {
            turnList.add(a);
        }
    }


    public String getWinName() {
        return name + " - Win!!!";
    }
}
