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
import java.util.HashSet;

public class Main
{
    
    public static ArrayList <Integer> primeFactors[] = new ArrayList[1001];
    
    public static void main(String[] args)
    {
        buildFactors();
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int q = puttingvaluesinside.nextInt();
        for(int i = 1; i <= q; i++)
        {
            int from = puttingvaluesinside.nextInt();
            int to = puttingvaluesinside.nextInt();
            System.out.println("Case "+i+": "+bfs(from, to));
        }
    }
    
    public static void buildFactors()
    {
        primeFactors[0] = primeFactors[1] = new ArrayList<Integer>();
        for(int i = 4; i < primeFactors.length; i += 2)
        {
            primeFactors[i] = new ArrayList<Integer>();
            primeFactors[i].add(2);
        }
        for(int i = 3; 2 * i < primeFactors.length; i += 2)
        {
            if(primeFactors[i] == null)
            {
                for(int j = i + i; j < primeFactors.length; j += i)
                {
                    if(primeFactors[j] == null)
                        primeFactors[j] = new ArrayList<Integer>();
                    primeFactors[j].add(i);
                }
            }
        }
//        for(int i = 0; i < primeFactors.length; i++)
//            System.out.println(i+" --> "+primeFactors[i]);
    }
    
    public static int bfs(int from, int to)
    {
        if(from == to) return 0;
        if(primeFactors[from] == null) return -1;
        if(from == 1 || from == 0) return -1;
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> level = new ArrayList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(from);
        level.add(0);
        while (queue.size() != 0)
        {
            int t = queue.get(0);
            ArrayList <Integer> factors = primeFactors[t];
            if(factors == null)
            {
                queue.remove(0);
                level.remove(0);
                continue;
            }
            int size = factors.size();
            while (size --> 0)
            {
                int k = factors.get(size);
                if(k + t == to) return level.get(0) + 1;
                if(visited.contains(k + t)) continue;
                if(k + t < to)
                {
                    queue.add(k + t);
                    level.add(level.get(0) + 1);
                    visited.add(k + t);
                }
            }
            queue.remove(0);
            level.remove(0);
        }
        return -1;
    }
    
}
