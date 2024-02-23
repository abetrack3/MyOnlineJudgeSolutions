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
//        long runtime = System.nanoTime();
        Scanner puttingvaluesinside = new Scanner(System.in);
        long arr[] = new long[10001];
        build2(arr);
//        System.out.println(java.util.Arrays.toString(arr));
        while (puttingvaluesinside.hasNextInt())
            System.out.println(arr[puttingvaluesinside.nextInt()]);
//        runtime = System.nanoTime() - runtime;
//        System.out.println("runtime = " + runtime/1000000);
//        System.out.println(multiplicationMod(2, 12, 20));
//        System.out.println(additionMod(11, 1, 7));
    }
    
    public static void build(long arr[])
    {
        for(int i = 1; i<arr.length; i++)
        {
            long k = 1;
            for(int j = 1; j <= 18; j++)
            {
                if(k%i == 0)
                {
                    arr[i] = k;
                    arr[i] = (""+arr[i]).length();
                    break;
                }
                else
                {
                    k = k*10 + 1;
                }
            }
        }
    }
    
    public static void build2(long arr[])
    {
        for(int i = 1; i < arr.length; i++)
        {
            if(i%2==0||i%5==0)
                continue;
            int count = 0;
            long d = 1;
            long fucker = i;
            while (true)
            {
                if(d%fucker == 0)
                {
                    count++;
//                    System.out.println("count = " + count);
                    arr[i] = count;
                    break;
                }
                else
                {
                    count++;
                    d = additionMod(multiplicationMod(d, 10, fucker), 1, fucker);
                }
            }
        }
    }
    
    public static long multiplicationMod(long a, long b, long c)
    {
        return ((a%c)*(b%c))%c;
    }
    
    public static long additionMod(long a, long b, long c)
    {
        return ((a%c)+(b%c))%c;
    }
    
}
