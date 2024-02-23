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
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while (puttingvaluesinside.hasNextInt())
        {
            long a = puttingvaluesinside.nextLong();
            long b = puttingvaluesinside.nextLong();
            if(solve(a, b))
                System.out.println(b+" divides "+a+"!");
            else
                System.out.println(b+" does not divide "+a+"!");
        }
    }
    
    public static boolean solve(long a, long b)
    {
        if(b == 0) return true;
        if(a == 0) return b == 1;
        if(b == 1) return true;
        HashMap<Long, Long> pf = new HashMap<Long, Long>();
        primeFactorization(b, pf);
        for(Long x:pf.keySet())
        {
            long power = (long)pf.get(x);
            long total = totalNumberOfI(x, a);
            if(power > total) return false;
        }
        
        return true;
    }
    
    public static int totalNumberOfI(long i, long limit)
    {
        long t = i;
        int ans = 0;
        while (t <= limit)
        {
            ans += limit / t;
            t *= i;
        }
        return ans;
    }
    
    public static void primeFactorization(long t, HashMap <Long, Long> list)
    {
        //Requires HashMap
        //this condition saves from the function going into an inifnite loop
        //if t == 0
        if(t == 0)
        {
            long qq = 0;
            long ww = 1;
            list.put(qq, ww);
            return;
        }
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
    
}
