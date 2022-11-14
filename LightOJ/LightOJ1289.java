/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.BitSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    
    public static int prime[];
    public static int primeFactorial[];
    public static final int range = (int)Math.pow(10, 8);
    public static final long mod = (long)Math.pow(2, 32);
    
    public static void main(String[] args) throws Exception
    {
        build();
        run();
    }
    
    public static void run() throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++)
        {
            int t = Integer.parseInt(br.readLine());
            sb.append("Case "+i+": "+solve(t)+"\n");
        }
        System.out.print(sb);
    }
    
    public static String solve(int t)
    {
        long a = Integer.toUnsignedLong(primeFactorial[binarySearch(t)]);
        long b = Integer.toUnsignedLong(powerMinusOne(t));
        long c = Long.remainderUnsigned(a * b, mod);
        return ""+Long.toUnsignedString(c);
    }
    
    public static void build()
    {
        BitSet b = new BitSet(range);
        b.set(0);
        b.set(1);
        for(int i = 4; i < b.size(); i += 2)
            b.set(i);
        for(int i = 3; i * i < b.size(); i += 2)
        {
            if(!b.get(i))
            {
                for(int j = i * i; j < b.size(); j += 2 * i)
                    b.set(j);
            }
        }
        b.flip(0, b.size());
        int index = 0;
        prime = new int[b.cardinality()];
        for(int i = 2; i != -1; i = b.nextSetBit(i + 1))
            prime[index++] = i;
        b = null;
        System.gc();
        primeFactorial = new int[prime.length];
        primeFactorial[0] = 2;
        for(int i = 1; i < prime.length; i++)
            primeFactorial[i] = prime[i] * primeFactorial[i - 1];
    }
    
    public static int binarySearch(int t)
    {
        int left = 0;
        int right = prime.length - 1;
        int mid = (left + right) / 2;
        while (left <= right)
        {
            if(prime[mid] == t) return mid;
            if(prime[left] == t) return left;
            if(prime[right] == t) return right;
            if(t > prime[mid])
                left = mid + 1;
            if(t < prime[mid])
                right = mid - 1;
            mid = (left + right) / 2;
        }
        return mid;
    }
    
    public static int powerMinusOne(int t)
    {
        int ans = 1;
        for(int i = 0; (long)(prime[i] * prime[i]) <= t; i++)
        {
            long temp = prime[i];
            while (temp * prime[i] <= t)
            {
                temp *= prime[i];
                ans *= prime[i];
            }
        }
        return ans;
    }
    
    public static long multiplicationMod(long a, long b, long c)
    {
        return ((a%c)*(b%c))%c;
    }
    
}
