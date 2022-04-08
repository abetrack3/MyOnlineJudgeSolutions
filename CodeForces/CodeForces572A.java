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
        Scanner puttingvaluesinside = new Scanner(System.in);
        int arr1[] = new int[puttingvaluesinside.nextInt()];
        int arr2[] = new int[puttingvaluesinside.nextInt()];
        int k = puttingvaluesinside.nextInt()-1;
        int m = arr2.length-puttingvaluesinside.nextInt();
        for(int i=0;i<arr1.length;i++)
            arr1[i] = puttingvaluesinside.nextInt();
        for(int i=0;i<arr2.length;i++)
            arr2[i] = puttingvaluesinside.nextInt();
        if(k>=arr1.length||m<0)
        {
            System.out.println("NO");
            return;
        }
        System.out.println((arr1[k]<arr2[m])?"YES":"NO");
    }
}
