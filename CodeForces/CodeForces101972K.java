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
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            
            int size = puttingvaluesinside.nextInt();
            puttingvaluesinside.nextLine();
            char [] arr1 = puttingvaluesinside.nextLine().toCharArray();
            char [] arr2 = puttingvaluesinside.nextLine().toCharArray();
            
            char lastCheck=' ', current=' ';
            boolean differenceFound = false, hope = true;
            int z=0, count=0;
            
            for(int i=0;i<size;i++)
            {
                if(arr1[i]!=arr2[i])
                {
                    lastCheck = arr1[i];
                    current = arr2[i];
                    differenceFound = true;
                    z = i;
                    count++;
                    break;
                }
            }
            
            if(!differenceFound)
            {
                System.out.println("YES");
                continue;
            }
            
            for(int i = z+1;i<size;i++)
            {
                if(arr1[i]!=arr2[i])
                {
                    if(current == arr1[i])
                    {
                        current = arr2[i];
                        count++;
                    }
                    else
                    {
                        hope = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            
            if(!hope)
                continue;
            
            if(count>1&&current == lastCheck)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
}
