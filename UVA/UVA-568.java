/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    
    public static ArrayList <Integer> primes = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
        build();
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while (puttingvaluesinside.hasNextInt())
        {
            int t = puttingvaluesinside.nextInt();
            System.out.println(output(t, solve(t)));
        }
    }
    
    public static String output(int t, int a)
    {
        String s = " -> "+a;
        if(t == 10000) return t+s;
        else if(t < 10) return "    "+t+s;
        else if(t < 100) return "   "+t+s;
        else if(t < 1000) return "  "+t+s;
        else return " "+t+s;
    }
    
    public static int solve(int n)
    {
        //caching
        if(n == 3) return 6;
        else if(n == 0 || n == 1) return 1;
        else if(n == 4 || n == 7) return 4;
        else if(n == 9 || n == 10) return 8;
        else if(n == 2 || n == 5 || n == 6 || n == 8) return 2;
        //initialization
        int totalNumberOf2 = totalNumberOfI(2, n);
        int totalNumberOf3 = totalNumberOfI(3, n);
        int totalNumberOf5 = totalNumberOfI(5, n);
        totalNumberOf2 -= totalNumberOf5;
        int ans = 2;
        for(int i = 2; i <= totalNumberOf2; i++)
            ans = multiplicationMod(ans, 2, 10);
        for(int i = 1; i <= totalNumberOf3; i++)
            ans = multiplicationMod(ans, 3, 10);
        //hawl through
        int index = 3;
        while (index < primes.size())
        {
            int prime = primes.get(index);
            if(prime > n) break;
            index++;
            int totalNumberOfPrime = totalNumberOfI(prime, n);
            for(int i = 1; i <= totalNumberOfPrime; i++)
                ans = multiplicationMod(ans, prime, 10);
        }
        return ans;
    }
    
    public static int totalNumberOfI(int i, int limit)
    {
        int t = i;
        int ans = 0;
        while (t <= limit)
        {
            ans += limit / t;
            t *= i;
        }
        return ans;
    }
    
    public static int multiplicationMod(int a, int b, int c)
    {
        return ((a%c)*(b%c))%c;
    }
    
    public static void build()
    {
        long runtime = System.nanoTime();
        int arr[] = new int[10001];
        createSieve(arr);
        runtime = System.nanoTime();
        primes.add(2);
        for(int i = 3; i < arr.length; i += 2)
            if (arr[i] == 0) primes.add(i);
        runtime = System.nanoTime() - runtime;
        runtime /= 1000000;
//        System.out.println("runtime = " + runtime);
    }
    
    public static void createSieve(int [] arr)
    {
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=1;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=1;
            }
        }
    }
    
}
