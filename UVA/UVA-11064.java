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
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while(puttingvaluesinside.hasNextLong())
        {
            long n = puttingvaluesinside.nextLong();
//            System.out.println(bruteForce(n));
            System.out.println(solve(n));
        }
//        for (int i = 0; i <= 1000; i++)
//        {
////            long i = 4;
//            long a = bruteForce(i);
//            long b = solve(i);
//            if(a != b)
//                System.out.println(i+" "+a+" "+b);
//        }
    }
    
    public static long bruteForce(long n)
    {
        long count = 0;
        for (int i = 1; i < n; i++)
        {
            if(gcd(i, n) != 1 && gcd(i, n) != i)
                count++;
        }
        return count;
    }
    
    public static long solve(long n)
    {
        if(n == 0 || n == 1) return 0;
        long answer = n+1;
        HashMap <Long, Long> map = new HashMap<Long, Long>();
        long euler = eulerTotientFunctionPhi(n, map);
//        System.out.println("euler = " + euler);
        answer -= euler;
//        long count = countDivisor(map);
        long count = countNumberOfDivisors(n, map);
//        System.out.println("count = " + count);
        answer -= count;
        return answer;
    }
    
    public static long gcd(long a, long b) 
    { 
        if (a == 0) 
        	return b; 
        return gcd(b%a, a); 
    }
    
    public static void primeFactorization(long t, HashMap <Long, Long> list)
    {
        //Requires HashMap
        //divides by two
        //this condition saves from the function going into an inifnite loop
        //if t == 0
        if(t == 0)
        {
            long qq = 0;
            long ww = 1;
            list.put(qq, ww);
            return;
        }
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
    
    public static long eulerTotientFunctionPhi(long n, HashMap <Long, Long> map)
    {
        //requires primeFactorization
        //requires HashMap
        //saves the function from an inifinite loop
        //corner case
        if (n == 0 || n == 1) return n;
        long answer = n;
//        map = new HashMap<Long, Long>();
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
    
    public static long countNumberOfDivisors(long n, HashMap<Long, Long> list)
    {
        //requires HashMap
        //requires primeFactorization();
        if(n == 1 || n == 0) return n; //corner case
        long answer = 1;
        Long power[] = new Long[list.size()];
        list.values().toArray(power);
        for(long x:power)
            answer *= x+1;
        return answer;
    }
    
    public static long countDivisor(HashMap <Long, Long> list)
    {
        long count = 1;
        Long prime[] = new Long[list.size()];
        Long frequency[] = new Long[list.size()];
        list.keySet().toArray(prime);
        list.values().toArray(frequency);
        for(int i = 0; i < frequency.length; i++)
        {
//            count *= (prime[i] == 1) ? 1 : frequency[i] + 1;
            count *= frequency[i] + 1;
        }
        
        return count;
    }
    
}
