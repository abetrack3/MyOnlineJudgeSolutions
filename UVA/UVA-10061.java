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
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static int size = 1050001;
    public static double cumulativeLog[] = new double[size];
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static HashMap<Integer, Integer> pf[] = new HashMap[801];
    
    public static void main(String[] args) throws Exception
    {
        build();
        run();
    }
    
    public static void run() throws Exception
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while(puttingvaluesinside.hasNextInt())
        {
            int number = puttingvaluesinside.nextInt();
            int base = puttingvaluesinside.nextInt();
            System.out.println(solve(number, base));
        }
    }
    
    public static String solve(int number, int base)
    {
        HashMap <Integer, Integer> numberPF = new HashMap<Integer, Integer>();
        int t = trailingZeros(number, base, numberPF);
        long d = numberOfDigits(number, base, numberPF);
//        long d = numberOfDigits2(base, numberPF);
        return t+" "+d;
    }
    
    public static int trailingZeros(int number, int base, HashMap <Integer, Integer> numberPF)
    {
        HashMap <Integer, Integer> basePF = pf[base];
//        HashMap <Integer, Integer> numberPF = new HashMap<Integer, Integer>();
        primeFactorizationOfFactorial(number, numberPF);
        Integer prime[] = new Integer[basePF.size()];
        basePF.keySet().toArray(prime);
        Integer power[] = new Integer[prime.length];
        basePF.values().toArray(power);
        int max = 0;
        if(numberPF.containsKey(prime[0]))
        {
            int temp = numberPF.get(prime[0]);
            if(power[0] > temp) return 0;
            else max = temp / power[0];
        }
        else return 0;
        for(int i = 1; i < prime.length; i++)
        {
            if(numberPF.containsKey(prime[i]))
            {
                int temp = numberPF.get(prime[i]);
                if(power[i] > temp) return 0;
                else
                {
                    int temp2 = temp / power[i];
                    max = (max > temp2) ? temp2 : max;
                }
            }
            else return 0;
        }
        
        
        return max;
    }
    
    public static void primeFactorizationOfFactorial(int t, HashMap<Integer, Integer> map)
    {
        if(t == 0 || t == 1) return;
        for(int i = 0; i < primes.size(); i++)
        {
            int prime = primes.get(i);
            if(prime > t) break;
            map.put(prime, totalNumberOfI(prime, t));
        }
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
    
    public static long numberOfDigits(int number, int base, HashMap <Integer, Integer> numberPF)
    {
        if(number == 0 || number == 1)
            return 1;
        double answer = cumulativeLog[number];
        answer /= Math.log(base);
        answer = Math.ceil(answer);
        if(pf[base].equals(numberPF)) return (long) answer + 1;
        return (long)answer;
    }
    
    public static long numberOfDigits2(int base, HashMap <Integer, Integer> numberPF)
    {
        double answer = 0;
        for(int x : numberPF.keySet())
            answer += (double)numberPF.get(x) * Math.log10(x);
        answer /= Math.log10(base);
        answer = Math.ceil(answer);
        return (long)answer;
    }
    
    public static void build()
    {
        long runtime = System.nanoTime();
        //caching data for number of digits
        cumulativeLog[0] = -1;
        for (int i = 2; i < cumulativeLog.length; i++)
            cumulativeLog[i] = Math.log(i) + cumulativeLog[i-1];
        //generating prime numbers
        int arr[] = new int[size];
        createSieve(arr);
        primes.add(2);
        for(int i = 3; i < arr.length; i += 2)
            if(arr[i] == 0) primes.add(i);
        //prime factorizations of bases
        pf[0] = new HashMap<Integer, Integer>();
        pf[1] = new HashMap<Integer, Integer>();
        for(int i = 2; i < pf.length; i++)
        {
            pf[i] = new HashMap<Integer, Integer>();
            primeFactorization(i, pf[i]);
        }
        
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
    
    public static void primeFactorization(int t, HashMap <Integer, Integer> list)
    {
        //Requires HashMap
        //this condition saves from the function going into an inifnite loop
        //if t == 0
        if(t == 0)
        {
            int qq = 0;
            int ww = 1;
            list.put(qq, ww);
            return;
        }
        //divides by two
        while(t%2==0)
        {
//            list.add((long)(2));
            int m = 2;
            int n = 1;
            if(list.containsKey(m))
                list.put(m, list.get(m)+1);
            else
                list.put(m, n);
            t/=2;
        }
        //check for all possible odd prime number divisor
        for(int i = 3; i*i <= t; i += 2)
        {
            if(t%i==0)
            {
//                list.add((long)i);
                if(list.containsKey(i))
                list.put((int)i, list.get(i)+1);
            else
                list.put((int)i, (int)1);
                t /= i;
                i -= 2;
            }
        }
        //if t at the end is a prime number
        if(t > 2)
        {
//            list.add(t);
            if(list.containsKey(t))
                list.put((int)t, list.get(t)+1);
            else
                list.put((int)t, (int)1);
        }
        if(list.size() == 0)
        {
//            list.add(t);
            list.put(t, (int)1);
        }
    }
    
}
