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

public class Main
{
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args)
    {
//        for (int i = 1; i <= 100; i++)
//        {
////            System.out.println(ANSI_PURPLE+"Testcase: ("+i+")"+ANSI_RESET);
//            for (int j = i + 1; j <= 100; j++)
//            {
////                System.out.println(ANSI_PURPLE+"Testcase: ("+i+", "+j+")"+ANSI_RESET);
//                bruteForce(i, j);
////                if(bruteForce(i, j) != solve(i, j))
////                    System.out.println(i+" "+j);
//            }
//        }
        
        //4 6
        //4 8
        //4 10
        
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int a = puttingvaluesinside.nextInt();
            int b = puttingvaluesinside.nextInt();
            System.out.println(solve(a, b)?a+" "+b:-1);
        }
        
    }
    
    public static boolean bruteForce(int gcd, int lcm)
    {
        boolean flag = true;
        for (int i = gcd; i <= lcm && flag; i++)
        {
            for (int j = gcd; j <= lcm; j++)
            {
                if(gcd(i, j) == gcd && lcm(i, j) == lcm)
                {
                    System.out.println(ANSI_PURPLE+"Testcase: ("+gcd+", "+lcm+")"+ANSI_RESET);
                    System.out.println(ANSI_GREEN+"Match found!!"+ANSI_RESET);
                    System.out.println(ANSI_GREEN+"i = " + i+ANSI_RESET);
                    System.out.println(ANSI_GREEN+"j = " + j+ANSI_RESET);
                    flag = false;
                    return true;
//                    break;
                }
            }
        }
        if(flag)
        {
//            System.out.println(ANSI_RED+"Match not found :("+ANSI_RESET);
            return false;
        }
        return false;
    }
    
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
        	return b; 
        return gcd(b%a, a); 
    }
    
    public static int lcm(int a, int b)
    {
        return (a*b)/gcd(a, b);
    }
    
    public static boolean solve(int gcd, int lcm)
    {
        return lcm % gcd == 0;
    }
    
}
