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

public class Main
{
    
    public static void main(String[] args)
    {
        int arr1[] = new int[1001];
        int arr2[] = new int[1001];
        for(int i=1;i<=1000;i++)
        {
        	arr1[i] = DivisorCountManual(i);
        	arr2[i] = i;
        }
        sort(arr1, arr2);
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        for(int i=1;i<=t;i++)
            System.out.println("Case "+i+": "+arr2[puttingvaluesinside.nextInt()]);
        
    }
    
    public static int DivisorCountManual(int x)
    {
        int count=0;
        for(int i=1;i*i<=x;i++)
        {
            if(x%i==0)
            {
                count+=2;
                if(i*i==x)
                    count--;
            }
        }
        return count;
    }
    
    public static void sort(int arr1[], int arr2[])
    {
        for(int i=arr1.length-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if((arr1[j]>arr1[j+1])||((arr1[j]==arr1[j+1])&&(arr2[j]<arr2[j+1])))
                {
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                    
                    temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
            }
        }
    }
    
}
