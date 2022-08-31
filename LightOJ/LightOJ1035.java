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
    
    public static int arr[][] = new int[101][101];
    
    public static void main(String[] args)
    {
        build();
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = puttingvaluesinside.nextInt();
            String s = "Case "+i+": "+n+" = ";
            int j = 2;
            for(;j < arr.length;j++)
            {
                if (arr[n][j] > 0)
                {
                    s += j+" ("+arr[n][j]+")";
                    j++;
                    break;
                }
            }
            for (;j < arr.length; j++)
            {
                if (arr[n][j] > 0)
                    s += " * "+j+" ("+arr[n][j]+")";
            }
            System.out.println(s);
        }
    }
    
    public static void build()
    {
        for (int i = 0; i < arr.length; i++)
            primeFactorization(i);
//        for(int x[]:arr)
//            System.out.println(java.util.Arrays.toString(x));
//        System.out.println();
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 1; j < arr.length; j++)
            {
                arr[j][i] += arr[j-1][i];
            }
        }
//        for(int x[]:arr)
//            System.out.println(java.util.Arrays.toString(x));
//        System.out.println();
    }
    
    public static void primeFactorization(int k)
    {
        if(k == 0 || k == 1)
            return;
        int t = k;
        while (t % 2 == 0)
        {
            t /= 2;
            arr[k][2]++;
        }
        for(int i = 3; i*i <= t; i += 2)
        {
            if (t % i == 0)
            {
                while (t % i == 0)
                {
                    t /= i;
                    arr[k][i]++;
                }
            }
        }
        if (t > 2)
        {
            arr[k][t]++;
            t /= t;
        }
    }
    
}
