package com.matialabs;

public class Board
{
    private static char board[][] = {{'-', '-', '-'},
                                    {'-', '-', '-'},
                                    {'-', '-', '-'}};


    /**
     * This function prints the board array
     */
    public static void printBoard()
    {
        for (int i = 0; i <board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print("         "+board[i][j] + "       ");
            }
            System.out.println("\n\n\n\n");
        }
    }

    /**
     * This function update a certain cell with given symbol
     * @param row
     *      the row parameter 1-3
     * @param col
     *      the col parameter 1-3
     * @param symbol
     *      X or O
     */
    public static void update(int row, int col, char symbol)
    {
        board[row][col] = symbol;
    }

    /**
     * Checks if symbol has won (col -> row -> slants)
     * @param symbol
     *      X or O - checks to see if symbol won
     * @return
     *      true for win, false for no win
     */
    public static boolean win(char symbol)
    {

       if(row(0, symbol)||row(1, symbol)||row(2,symbol)||col(0, symbol)||col(1, symbol)||col(2, symbol)||mainSlant(symbol)||secondSlant(symbol))
        {
            return true;
        }
        return false;

    }


    /**
     * Checks for row win
     * @param row
     *      the row to check for three in a row
     * @param symbol
     *      the symbol to look for three in a row
     * @return
     *      Return true if three in a *row* is found
     */
    private static boolean row(int row, char symbol)
    {
        for (int j = 0; j < board[row].length; j++)
        {
            if (board[row][j] != symbol)
            {
                return false;
            }
        }
        return true;

    }

    /**
     * Retruns the board
     * @return
     *      returns the board
     */
    public static char[][] getBoard()
    {
        return board;
    }

    /**
     * Checks for col win
     * @param col
     *      the row to check for three in a col
     * @param symbol
     *      the symbol to look for three in a col
     * @return
     *      Return true if three in a *col* is found
     */
    public static boolean col(int col, char symbol)
    {
        for (int j = 0; j < board.length; j++)
        {
            if (board[j][col] != symbol)
            {
                return false;
            }
        }
        return true;

    }
    /**
     * Checks for main Slant win
     * @param symbol
     *      the symbol to look for three in a slant
     * @return
     *      Return true if three in a *slant* is found
     */
    private static boolean mainSlant( char symbol)
    {
        for (int i = 0; i < board.length ; i++)
        {
            if (board[i][i] != symbol)
            {
                return false;
            }
        }
        return true;

    }
    /**
     * Checks for second slant win
     * @param symbol
     *      the symbol to look for the three in a row
     * @return
     *      Return true if three in a *second slant* is found
     */
    private static boolean secondSlant(char symbol)
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i][board.length - i - 1] != symbol)
            {
                return false;
            }
        }
        return true;
    }
}
