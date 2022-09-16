/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = Integer.parseInt(puttingvaluesinside.next());
        for(int i = 1; i <=t; i++)
        {
            String s1 = puttingvaluesinside.next();
            if(s1.charAt(0) == '-') s1 = s1.substring(1);
//            System.out.println("s1 = " + s1);
            String s2 = puttingvaluesinside.next();
            if(s2.charAt(0) == '-') s2 = s2.substring(1);
//            System.out.println("s2 = " + s2);
            System.out.println("Case "+i+":"+(solve(s1, Long.parseLong(s2))?"":" not")+" divisible");
        }
    }
    
    public static boolean solve(String s, long n)
    {
        char c[] = s.toCharArray();
        return 0 == bigStringMod(c, n, c.length-1);
    }
    
    public static long bigStringMod(char c[], long mod, int lastIndex)
    {
        if(lastIndex == 0) return (c[0] - '0') % mod;
        return additionMod(
                c[lastIndex]-'0', 
                multiplicationMod(
                        10,
                        bigStringMod(
                                c,
                                mod,
                                lastIndex-1),
                        mod),
                mod);
    }
    
    public static long additionMod(long a, long b, long c)
    {
        return ((a%c)+(b%c))%c;
    }
    
    public static long multiplicationMod(long a, long b, long c)
    {
        return ((a%c)*(b%c))%c;
    }
    
}
