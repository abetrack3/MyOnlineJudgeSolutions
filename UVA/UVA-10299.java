/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t != 0)
        {
            System.out.println(eulerTotientFunctionPhi(t));
//            System.out.println("bruteForce(t) = " + bruteForce(t));
//            System.out.println("eulerTotientFunctionPhi("+t+") = " 
//                    + eulerTotientFunctionPhi(t));
            t = puttingvaluesinside.nextInt();
        }
//        while (t-->0)
//        {
//            if(bruteForce(t) != eulerTotientFunctionPhi(t))
//            {
//                System.out.println("Error: " + t);
//                System.out.println("bruteForce(t) = " + bruteForce(t));
//                System.out.println("euler(t) = " + eulerTotientFunctionPhi(t));
//                break;
//            }
//            else System.out.println("t = " + t);
//        }
    }
    
    public static int bruteForce(int n)
    {
        int count = 0;
        for (int i = 1; i < n; i++)
        {
            if(gcd(i, n) == 1)
                count ++;
        }
        return count;
    }
    
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
        	return b; 
        return gcd(b%a, a); 
    }
    
    public static void primeFactorization(long t, HashMap <Long, Long> list)
    {
        //Requires HashMap
        //divides by two
        while(t%2==0)
        {
//            list.add((long)(2));
            long m = 2;
            long n = 1;
            if(list.containsKey(m))
                list.put(m, list.get(m)+1);
            else
                list.put(m, n);
            t/=2;
        }
        //check for all possible odd prime number divisor
        for(long i = 3; i*i <= t; i += 2)
        {
            if(t%i==0)
            {
//                list.add((long)i);
                if(list.containsKey(i))
                list.put((long)i, list.get(i)+1);
            else
                list.put((long)i, (long)1);
                t /= i;
                i -= 2;
            }
        }
        //if t at the end is a prime number
        if(t > 2)
        {
//            list.add(t);
            if(list.containsKey(t))
                list.put((long)t, list.get(t)+1);
            else
                list.put((long)t, (long)1);
        }
        if(list.size() == 0)
        {
//            list.add(t);
            list.put(t, (long)1);
        }
    }
    
    public static long eulerTotientFunctionPhi(long n)
    {
        //requires primeFactorization
        //requires HashMap
        if (n == 0) return 0;
        long answer = n;
        HashMap <Long, Long> map = new HashMap<Long, Long>();
        primeFactorization(n, map);
        //divides n by all the distinct prime divisor
        Long primes[] = new Long[map.size()];
        map.keySet().toArray(primes);
        for(long x:primes)
            answer /= x;
        //multiplies by each distince prime-1;
        for(long x:primes)
            answer *= x-1;
        return answer;
    }
    
}
