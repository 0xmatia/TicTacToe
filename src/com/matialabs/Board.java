package com.matialabs;

public class Board
{
    public static void printBoard(int arr[][])
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

    public static boolean win(char arr[][])
    {

        if(row(arr,0)||row(arr,1)||row(arr,2)||col(arr, 0)||col(arr, 1)||col(arr, 2)||mainSlant(arr)||secondSlant(arr))
        {
            return true;
        }

        return false;

    }


    private static boolean row(char arr[][], int row)
    {
        int flag = 0; // if flag is two, we are ok (row -1);
        for (int j = 0; j < arr[row].length - 1; j++)
        {
            if (arr[row][j] == arr[row][j+1])
            {
                flag++;
            }
        }
        return flag==arr[row].length-1? true: false;

    }

    private static boolean col(char arr[][], int col)
    {
        int flag = 0; // if flag is two, we are ok (row -1);
        for (int j = 0; j < arr.length - 1; j++)
        {
            if (arr[j][col] == arr[j+1][col])
            {
                flag++;
            }
        }
        return flag==arr.length-1? true: false;

    }

    private static boolean mainSlant(char[][] arr)
    {
        int flag = 0;
        for(int i = 0; i<arr.length-1; i++)
        {
            if(arr[i][i]==arr[i+1][i+1])
            {
                flag++;
            }
        }
        return flag==arr.length-1? true: false;

    }
    private static boolean secondSlant(char[][] arr)
    {
        int flag = 0;
        for(int i = 0; i<arr.length-1; i++)
        {
            if(arr[i][arr.length-i-1]==arr[i+1][arr.length-i-1])
            {
                flag++;
            }
        }
        return flag==arr.length-1? true: false;

    }
}
