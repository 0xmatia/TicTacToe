package com.matialabs;

import java.util.Scanner;

public class Main
{

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
        System.out.println("Welcome to my Tic Tac Toe!");
        System.out.println("Player X starts, you have 3x3 board. The board will be printed at the start of each round.\n\n");
        do
        {


            Board.printBoard(); //prints the board for the first time
            System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (3 3 is max) ");
            row = in.nextInt()-1; // -1 to make the coordinates real
            col = in.nextInt()-1;
            while ( row > 2 || row < 0 || col > 2 || col < 0||(Board.getBoard()[row][col] == otherPlayer || Board.getBoard()[row][col] == currentPlayer) ) //checks input both for used places and for something that cant be
            {
                System.out.println("\n\n\n\n\n\n\n\n");
                System.out.println("                   ----WRONG INPUT-----");
                System.out.println("\n");
                Board.printBoard();
                System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
                row = in.nextInt()-1;
                col = in.nextInt()-1;
            }
            Board.update(row, col, currentPlayer); //this function update the board
            turns++;

            if (Board.win(currentPlayer) || turns==9) //this checks to see if anyone won. If true, we break the loop and print the board, else we change the player
            {
                inGame = false;
                System.out.println("\n\n\n\n\n\n\n\n");
                Board.printBoard();
            }
            else
            {
                temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;
            }

        } while (inGame);
        if (Board.win(currentPlayer))
        {
            System.out.println("Player " + currentPlayer + " Wins!");
        }
        else
        {
            System.out.println("Tie!");
        }

    }
}
