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
    
    public static long primeSum[];
    public static long lsopf[];
    
    public static void main(String[] args)
    {
        long runtime = System.nanoTime();
        build();
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = puttingvaluesinside.nextInt();
            int m = puttingvaluesinside.nextInt();
            System.out.println("Case #"+i+":\n"+solve(n, m));
        }
//        buildTestCaseForRuntimeAnalysis();
        runtime = System.nanoTime() - runtime;
//        System.out.println("runtime = " + runtime/1000000);
    }
    
    public static long solve(int n, int m)
    {
        
        if(n > m)
        {
            int temp = n;
            n = m;
            m = temp;
        }
        long k = lsopf[n];
        for(int i = n + 1; i <= m; i++)
            k = (lsopf[i] > k)? lsopf[i] : k;
        return k;
    }
    
    public static void build()
    {
        primeSum = new long[500001];
//        long primeSum[] = new long[11];
        lsopf = new long[primeSum.length];
        buildSumOfPrimeFactor(primeSum);
//        testBuildSumOfPrimeFactor(primeSum);
//        System.out.println(java.util.Arrays.toString(primeSum));
        buildLSOPF(primeSum, lsopf);
//        System.out.println(java.util.Arrays.toString(lsopf));
    }
    
    public static void buildSumOfPrimeFactor(long arr[])
    {
        for(int i = 2; i < arr.length; i += 2)
        {
//            arr[i] = 2;
            long x = i;
            while (x % 2 == 0)
            {
                x /= 2;
                arr[i] += 2;
            }
        }
        for(int i = 3; i < arr.length; i+=2)
        {
            if(arr[i] == 0)
            {
                for(int j = i; j < arr.length; j+=i)
                {
//                    arr[j] += i;
                    long x = j;
                    while(x % i == 0)
                    {
                        x /= i;
                        arr[j] += i;
                    }
                }
            }
        }
    }
    
    public static void testBuildSumOfPrimeFactor(long arr[])
    {
        for(int i = 2; i < arr.length; i++)
        {
            int k = i;
            long sum = 0;
            //divides by 2
            while (k % 2 == 0)
            {
                sum += 2;
                k /= 2;
            }
            //divides by other odd prime numbers
            for (int j = 3; j*j <= k; j+=2)
            {
                if(k % j == 0)
                {
                    sum += j;
                    k /= j;
                    j -=2;
                }
            }
            if(k > 2)
                sum += k;
            arr[i] = sum;
//            if(arr[i] != sum)
//            {
//                System.out.println("Error for "+i);
//                System.out.println("Algo "+arr[i]);
//                System.out.println("Brute "+sum);
//            }
        }
    }
    
    public static void buildLSOPF(long primeSum[], long lsopf[])
    {
        lsopf[2] = 1;
        lsopf[3] = 1;
        for(int i = lsopf.length - 1; i > 3; i--)
            lsopf[i] = LSOPF(primeSum, lsopf, i);
    }
    
    public static long LSOPF(long primeSum[], long lsopf[], int n)
    {
        if(lsopf[n] == 0)
        {
            lsopf[n] = 1 + 
                    ((primeSum[n]==n)?0
                    :LSOPF(primeSum, lsopf, (int)primeSum[n]));
            return lsopf[n];
        }
        return lsopf[n];
    }
    
    public static void buildTestCaseForRuntimeAnalysis()
    {
//        for (int i = 2; i < 1001; i++)
//        {
//            System.out.println(i+" "+i);
//        }
        //worst case scenario
        int t = 150;
        while (t-->0)
        {
            System.out.println(t);
            solve(2, lsopf.length-1);
        }
    }
    
}
