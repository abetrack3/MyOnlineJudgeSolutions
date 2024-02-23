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
        test();
//        run();
        run2();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t != 0)
        {
            System.out.println("f91("+t+") = " + f91(t));
            t = puttingvaluesinside.nextInt();
        }
    }
    
    public static void run2() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t != 0)
        {
            out.append("f91("+t+") = " + f91Version2(t)+"\n");
            t = Integer.parseInt(br.readLine());
        }
        System.out.print(out);
    }
    
    public static int f91Version2(int n)
    {
        return (n > 100) ? n - 10 : 91;
    }
    
    public static int f91(int n)
    {
        if(n<=100)
            return f91(f91(n+11));
        else if(n>100)
            return (n-10);
        return 0;
    }
    
    public static void test()
    {
        for(int i = -100; i <= 200; i++)
        {
            int a = f91(i);
            int b = f91Version2(i);
            if(a != b)
            {
                System.out.println("Error detected for i = " + i);
                System.out.println("a = " + a);
                System.out.println("b = " + b);
            }
        }
    }
    
}