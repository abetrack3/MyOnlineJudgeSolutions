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
import java.io.File;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
//        test();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        long t = puttingvaluesinside.nextLong();
        while (t != 0)
        {
            System.out.println(solve(t));
            t = puttingvaluesinside.nextLong();
        }
    }
    
    public static long solve(long t)
    {
        return quick(t);
//        return bruteForce(t);
    }
    
    public static long quick(long t)
    {
        boolean neg = t < 0;
        if(neg) t = -t;
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        primeFactorization(t, map);
        Long power[] = new Long[map.size()];
        map.values().toArray(power);
        long answer;
        if(power.length == 1)
            answer = power[0];
        else
        {
            answer = gcd(power[0], power[1]);
            for(int i = 2; i < power.length; i++)
                answer = gcd(answer, power[i]);
        }
        if(neg) if(answer % 2 == 0) while(answer % 2 == 0) answer /= 2;
        return answer;
    }
    
    public static long bruteForce(long t)
    {
        //the code is wrong..... SUCK IT LOSER!!!
        long ans = quick((t > 0)? t : -t);
        long max = 1;
        if(t < 0)
        {
            long i = ans;
            i -= (ans % 2 == 0)? 1 : 0;
            for(; i >= 1; i -= 2)
            {
                double temp = Math.pow(t, 1/(double)i);
                long temp2 = (long)temp;
                long temp3 = (long)Math.pow(temp2, i);
                if(temp3 == t)
                {
                    if(i > max)
                        max = i;
                }
            }
        }
        else return ans;
        return max;
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
    
    public static long gcd(long a, long b)
    {
        if(a == 0 || b == 0) return a + b;
        return gcd(b%a, a);
    }
    
    public static void test() throws Exception
    {
        Scanner input = new Scanner(new File("ProblemMInput.txt"));
        Scanner acceptedOutput = new Scanner(new File("ProblemMAcceptedOutput.txt"));
        while (input.hasNextInt())
        {
            int t = input.nextInt();
            long a = solve(t);
            long b = acceptedOutput.nextInt();
            if(a != b)
            {
                System.out.println("Error detected for i = "+t);
                System.out.println("your answer = "+a);
                System.out.println("accepted answer = "+b);
                return;
            }
        }
    }
    
}
