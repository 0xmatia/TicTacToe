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
    private static int ROW;
    private static int COL;
    private static int turns = 0;

    public static void main(String[] args)
    {
        //System.out.println(Board.col(board, 1,'-'));

        System.out.println("Welcome to my Tic Tac Toe!");
        System.out.println("Player X starts, you have 3x3 board. The board will be printed at the start of each round.\n\n");
        do
        {

            Board.printBoard(board);
            System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
            ROW = in.nextInt();
            COL = in.nextInt();
            while ( ROW > 2 || ROW < 0 || COL > 2 || COL < 0||(board[ROW][COL] == otherPlayer || board[ROW][COL] == currentPlayer) )
            {
                System.out.println("\n\n\n\n\n\n\n\n");
                System.out.println("                   ----WRONG INPUT-----");
                System.out.println("\n");
                Board.printBoard(board);
                System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
                ROW = in.nextInt();
                COL = in.nextInt();
            }
            board = Board.update(board, ROW, COL, currentPlayer);

            if (Board.win(board, currentPlayer) || turns==8)
            {
                inGame = false;
                System.out.println("\n\n\n\n\n\n\n\n");
                Board.printBoard(board);
            }
            else
            {
                temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;
                //System.out.println("Current Player: "+currentPlayer+" Other player: "+otherPlayer);
            }
            turns++;
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
