package com.matialabs;

import java.util.Scanner;

public class Main
{
    private static char board[][] = {{'-', '-', '-'},
                                     {'-', '-', '-'},
                                    {'-', '-', '-'}};
    private static char currentPlayer = 'X';
    private static boolean inGame = true;
    private static Scanner in = new Scanner(System.in);
    private static char otherPlayer = 'O';
    private static char temp = 'O';
    private static int row;
    private static int col;
    private static int turns = 0;

    public static void main(String[] args)
    {
        //System.out.println(Board.col(board, 1,'-'));

        System.out.println("Welcome to my Tic Tac Toe!");
        System.out.println("Player X starts, you have 3x3 board. The board will be printed at the start of each round.\n\n");
        do
        {

            Board.printBoard(board);
            System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (3 3 is max) ");
            row = in.nextInt()-1;
            col = in.nextInt()-1;
            System.out.println("row: "+ row +" Col:"+ col);
            while ( row > 2 || row < 0 || col > 2 || col < 0||(board[row][col] == otherPlayer || board[row][col] == currentPlayer) )
            {
                System.out.println("\n\n\n\n\n\n\n\n");
                System.out.println("                   ----WRONG INPUT-----");
                System.out.println("\n");
                Board.printBoard(board);
                System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
                row = in.nextInt()-1;
                col = in.nextInt()-1;
            }
            board = Board.update(board, row, col, currentPlayer);
            turns++;

            if (Board.win(board, currentPlayer) || turns==9)
            {
                inGame = false;
                System.out.println("\n\n\n\n\n\n\n\n");
                Board.printBoard(board);
            }
            else
            {
                temp = currentPlayer; //temp = X
                currentPlayer = otherPlayer; //cp = O
                otherPlayer = temp;
                //System.out.println("Current Player: "+currentPlayer+" Other player: "+otherPlayer);
            }

        } while (inGame);
        if (Board.win(board, currentPlayer))
        {
            System.out.println("Player " + currentPlayer + " Wins!");
        }
        else
        {
            System.out.println("Tie!");
        }

    }
}
