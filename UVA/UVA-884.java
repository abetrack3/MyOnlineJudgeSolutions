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
import java.util.ArrayList;
//import java.io.File;

public class Main
{
    
    public static long arr[] = new long[1000001];
    
    public static void main(String[] args) throws Exception
    {
        build();
        Scanner puttingvaluesinside = new Scanner(System.in);
//        long t = puttingvaluesinside.nextLong();
        while (puttingvaluesinside.hasNextLong())
        {
            long t = puttingvaluesinside.nextLong();
            int temp = (int)t;
            System.out.println(arr[temp]);
//            t = puttingvaluesinside.nextLong();
        }
    }
    
    public static void build()
    {
        arr[0] = arr[1] = arr[2] = 1;
        int j = 3;
        for(long i = 3; i < arr.length; i++)
        {
            ArrayList <Long> list = new ArrayList<Long>();
            findFactor(i, list);
            arr[j] = list.size() + arr[j-1];
            j++;
        }
    }
    
    public static void findFactor(long t, ArrayList <Long> list)
    {
        //divides by two
        while(t%2==0)
        {
            list.add((long)(2));
            t/=2;
        }
        //check for all possible odd prime number divisor
        for(long i = 3; i*i <= t; i += 2)
        {
            if(t%i==0)
            {
                list.add((long)i);
                t /= i;
                i -= 2;
            }
        }
        //if t at the end is a prime number
        if(t > 2)
            list.add(t);
        if(list.size() == 0)
            list.add(t);
    }
    
}
