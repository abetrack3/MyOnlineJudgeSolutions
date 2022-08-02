/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abetrack3
 */
 
import java.util.Scanner;
 
public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int n = puttingvaluesinside.nextInt();
        int x = puttingvaluesinside.nextInt();
        long arr[] = new long[n];
        arr[0] = puttingvaluesinside.nextInt();
        for (int i = 1; i < arr.length; i++)
            arr[i] = arr[i - 1] + puttingvaluesinside.nextInt();
        if(arr[n - 1] < x) {System.out.println(-1); return;}
        int i = 0, j = java.util.Arrays.binarySearch(arr, x);
        j = (j < 0) ? -1 * (j + 1) : j;
        int min = j - i + 1;
        //frame shifting loop
        for (; j < n; j++)
        {
            while (i <= j)
            {
                if (i < n - 1)
                {
                    if(getSum(i + 1, j, arr) >= x) i++;
                    else break;
                }
                else break;
            }
            min = Math.min(min, j - i + 1);
        }
        System.out.println(min);
    }
    
    public static long getSum(int i, int j, long arr[])
    {
        if(i == 0) return arr[j];
        else return arr[j] - arr[i - 1];
    }
    
}