/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18101257
 */

import java.util.Scanner;

public class Main
{
    
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int sieve[] = new int[101];
        createSieve(sieve);
        int n = puttingvaluesinside.nextInt();
        while(n!=0)
        {
            int record [] = new int [101];
            
            int k = n;
            while(k>1)
            {
//                System.out.println("k = " + k);
                if(sieve[k]==1)
                {
                    record[k]++;
//                    System.out.println("here");
//                    for(int x: record)
                    
                }
                else
                {
//                    System.out.println("here2");
                    for(int i=2;i<=k;i++)
                    {
                        if(sieve[i]==1&&k%i==0)
                        {
//                            record[i]++;
                            int l = k;
                            while(l%i==0)
                            {
                                record[i]++;
                                l/=i;
                            }
                        }
                    }
                }
                k--;
            }
            
            System.out.print(RightJustification(n)+"! =");
            int count = 1;
            for(int x:record)
            {
                if(x!=0)
                {
                    if(count<16)
                    {
                        System.out.print(RightJustification(x));
                        count++;
                    }
                    else
                    {
                        count = 1;
                        System.out.print("\n      "+RightJustification(x));
                    }
                }
            }
            System.out.println();
            k--;
            
            n = puttingvaluesinside.nextInt();
        }
    }
    
    public static void createSieve(int sieve[])
    {
        sieve[2] = 1;
        sieve[3] = 1;
        sieve[5] = 1;
        sieve[7] = 1;
        sieve[11] = 1;
        sieve[13] = 1;
        sieve[17] = 1;
        sieve[19] = 1;
        sieve[23] = 1;
        sieve[29] = 1;
        sieve[31] = 1;
        sieve[37] = 1;
        sieve[41] = 1;
        sieve[43] = 1;
        sieve[47] = 1;
        sieve[53] = 1;
        sieve[59] = 1;
        sieve[61] = 1;
        sieve[67] = 1;
        sieve[71] = 1;
        sieve[73] = 1;
        sieve[79] = 1;
        sieve[83] = 1;
        sieve[89] = 1;
        sieve[97] = 1;
    }
    
    public static String RightJustification(int n)
    {
        if((n+"").length()==1)
            return "  "+n;
        else if((n+"").length()==2)
            return " "+n;
        return n+"";
    }
    
}