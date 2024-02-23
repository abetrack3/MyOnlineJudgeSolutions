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
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    
    public static int prime[];
    public static ArrayList<ArrayList<Integer>> cache;
    
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        build(32001);
//        System.out.println(java.util.Arrays.toString(prime));
//        System.out.println(cache.size());
        Scanner puttingvaluesinside = new Scanner(System.in);
        int left = puttingvaluesinside.nextInt();
        int right = puttingvaluesinside.nextInt();
        if(right < left)
        {
            int temp = left;
            left = right;
            right = temp;
        }
        while (!(left == 0 && right == 0))
        {
            solve(left, right);
            left = puttingvaluesinside.nextInt();
            right = puttingvaluesinside.nextInt();
            if(left > right)
            {
                int temp = left;
                left = right;
                right = temp;
            }
        }
        
    }
    
    public static void solve(int left, int right)
    {
        for(ArrayList <Integer> x : cache)
        {
            if(x.get(0) >= left && x.get(x.size() - 1) <= right)
            {
                System.out.print(x.get(0));
                for(int i = 1; i < x.size(); i++)
                    System.out.print(" "+x.get(i));
                System.out.println();
            }
        }
    }
    
    public static void build(int range)
    {
        BitSet sieve = createBitSetSieve(range);
        int size = sieve.cardinality();
        prime = new int[size];
        int index = 0;
        for(int i = 0; i < sieve.size(); i++)
        {
            if(sieve.get(i))
                prime[index++] = i;
        }
        buildSets();
    }
    
    public static BitSet createBitSetSieve(int size)
    {
        BitSet b = new BitSet(size);
        size = b.size();
        b.set(0);
        b.set(1);
        for(int i = 4; i < size; i += 2)
            b.set(i);
        for (int i = 3; i * i < size; i += 2)
        {
            if(!b.get(i))
            {
                for(int j = i * i; j < size; j += 2 * i)
                    b.set(j);
            }
        }
        b.flip(0, size);
        return b;
    }
    
    public static void buildSets()
    {
        cache = new ArrayList<ArrayList<Integer>>();
        for(int i = 2; i < prime.length; i++)
        {
            if(prime[i] - prime[i - 1] == prime[i - 1] - prime[i - 2])
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                cache.add(list);
                list.add(prime[i - 2]);
                list.add(prime[i - 1]);
                list.add(prime[i]);
                i++;
                while (i < prime.length
                        &&
                        (prime[i] - prime[i - 1]
                        == prime[i - 1] - prime[i - 2]))
                {
                    list.add(prime[i]);
                    i++;
                }
                    
            }
        }
    }
    
}
