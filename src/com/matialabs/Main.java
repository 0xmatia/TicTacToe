package com.matialabs;

public class Main {
    public static char board[][] = {{'X','O','X'},
                                    {'O','O','X'},
                                    {'O','X','X'}};
    public static void main(String[] args) {
        System.out.println(Board.win(board));

    }
}
