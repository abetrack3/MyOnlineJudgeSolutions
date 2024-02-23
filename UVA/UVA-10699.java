/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abrarshahriar
 */

import java.util.Scanner;
import java.util.HashSet;

public class Main
{
    
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int arr[] = new int[1000001];
        createRainbowSieve(arr);
        int a = puttingvaluesinside.nextInt();
        while(a!=0)
        {
            int b = a;
            HashSet <Integer>hs = new HashSet<Integer>();
            while(b!=1)
            {
                int c = (arr[b]==0)?b:arr[b];
                hs.add(c);
                b/=(arr[b]==0)?b:arr[b];
            }
            System.out.println(a+" : "+hs.size());
            a = puttingvaluesinside.nextInt();
        }
        
    }
    
    public static void createRainbowSieve(int [] arr)
    {
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=2;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=i;
            }
        }
    }
    
}
