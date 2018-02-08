package com.matialabs;

public class Board
{
    public static void printBoard(char arr[][])
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static char[][] update(char arr[][], int row, int col, char symbol)
    {
        arr[row][col] = symbol;
        return arr;
    }

    public static boolean win(char arr[][], char symbol)
    {

       if(row(arr,0, symbol)||row(arr,1, symbol)||row(arr,2,symbol)||col(arr, 0, symbol)||col(arr, 1, symbol)||col(arr, 2, symbol)||mainSlant(arr, symbol)||secondSlant(arr, symbol))
        {
            return true;
        }


        return false;

    }

    public static boolean tie(char board[][])
    {
        for(int i = 0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(board[i][j]=='-')
                {
                    return false;
                }

            }
        }
        return true;
    }


    private static boolean row(char arr[][], int row, char symbol)
    {
        for (int j = 0; j < arr[row].length; j++)
        {
            if (arr[row][j] != symbol)
            {
                return false;
            }
        }
        return true;

    }

    public static boolean col(char arr[][], int col, char symbol)
    {
        // int flag = 0; // if flag is two, we are ok (row -1);
        for (int j = 0; j < arr.length; j++)
        {
            if (arr[j][col] != symbol)
            {
                return false;
            }
        }
        return true;

    }

    private static boolean mainSlant(char[][] arr, char symbol)
    {
        int flag = 0;
        for (int i = 0; i < arr.length ; i++)
        {
            if (arr[i][i] != symbol)
            {
                return false;
            }
        }
        return true;

    }

    private static boolean secondSlant(char[][] arr, char symbol)
    {
        int flag = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i][arr.length - i - 1] != symbol)
            {
                return false;
            }
        }
        return true;
    }
}
