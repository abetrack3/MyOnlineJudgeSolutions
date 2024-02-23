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

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader puttingvaluesinside = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(puttingvaluesinside.readLine());
        while (t!=0)
        {
            int G=0;
            for(int i=1;i<t;i++)
            {
                for(int j=i+1;j<=t;j++)
                {
                    G+=gcd(i,j);
                }
            }
            System.out.println(G);
//            t--;
            t = Integer.parseInt(puttingvaluesinside.readLine());
        }
    }
    
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    }
    
}
