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
    
    public static HashMap <Long, Long> cache = new HashMap<Long, Long>();
    
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while (puttingvaluesinside.hasNextInt())
        {
            int t = puttingvaluesinside.nextInt();
            System.out.println(solve(t));
        }
            
    }
    
    public static long solve(long t)
    {
        if(t == 1 || t == 0) return t;
        if(cache.containsKey(t)) return cache.get(t);
        else
        {
            long temp = solve(t / 2) + solve(t / 3) + solve(t / 4);
            cache.put(t, (t > temp) ? t : temp);
            return cache.get(t);
        }
    }
    
}
