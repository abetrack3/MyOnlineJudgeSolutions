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
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader puttingvaluesinside = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(puttingvaluesinside.readLine());
        while(t-->0)
        {
            StringTokenizer s = new StringTokenizer(puttingvaluesinside.readLine());
            ArrayList <Integer> arr = new ArrayList<Integer>();
            while(s.hasMoreTokens())
                arr.add(Integer.parseInt(s.nextToken()));
            int max = gcd(arr.get(0), arr.get(1));
            for(int i = 0; i < arr.size()-1; i++)
            {
                for(int j = i+1; j < arr.size(); j++)
                {
                    int g = gcd(arr.get(i), arr.get(j));
                    if(g > max)
                        max = g;
                }
            }
            System.out.println(max);
        }
    }
    
    // extended Euclidean Algorithm 
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    }
    
}
