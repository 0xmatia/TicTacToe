package com.matialabs;

import java.util.Scanner;

public class Main {
    public static char board[][] = {{'-','-','-'},
                                    {'-','-','-'},
                                    {'-','-','-'}};
    public static char currentPlayer = 'X';
    public static boolean inGame = true;
    public static Scanner in = new Scanner(System.in);
    public static char otherPlayer = 'O';
    public static char temp = 'O';
    public static int ROW;
    public static int COL;
    public static void main(String[] args) {
        //System.out.println(Board.col(board, 1,'-'));

        System.out.println("Welcome to my Tic Tac Toe!");
        System.out.println("Player X starts, you have 3x3 board. The board will be printed at the start of each round.");
        do
        {

            Board.printBoard(board);
            System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
            ROW = in.nextInt();
            COL = in.nextInt();
            while(ROW>2||ROW<0||COL>2||COL<0 )
            {
                System.out.println("----WRONG INPUT-----");
                ROW = in.nextInt();
                COL = in.nextInt();
            }
           while((board[ROW][COL]==otherPlayer || board[ROW][COL]==currentPlayer))
            {
                System.out.println("\n\n\n\n*****This is already taken!*****");
                Board.printBoard(board);
                System.out.println("Player " + currentPlayer + ", please enter the row and column coordinates (2 2 is max) ");
                ROW = in.nextInt();
                COL = in.nextInt();
            }
            board = Board.update(board, ROW, COL, currentPlayer);

            if(Board.win(board, currentPlayer)||Board.tie(board))
            {
                inGame=false;
                Board.printBoard(board);
            }
            else
            {
                temp=currentPlayer;
                currentPlayer=otherPlayer;
                otherPlayer=temp;
                //System.out.println("Current Player: "+currentPlayer+" Other player: "+otherPlayer);
            }
        }while(inGame);
        if(!Board.tie(board))
        {
            System.out.println("Player "+currentPlayer+" Wins!");
        }
        else
        {
            System.out.println("Tie!");
        }

    }
}
