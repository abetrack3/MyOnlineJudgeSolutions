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
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int arr[] = new int[3];
            arr[0] = puttingvaluesinside.nextInt();
            arr[1] = puttingvaluesinside.nextInt();
            arr[2] = puttingvaluesinside.nextInt();
            Arrays.sort(arr);
            long ans = 0;
            if(arr[0]==arr[1]&&arr[1]==arr[2])
            {
                System.out.println(0);
                continue;
            }
            else if(arr[0]==arr[1])
            {
                int operator = 0;
                if(arr[2]>arr[1])
                    operator = -1;
                else
                    operator = 1;
                arr[2]+=operator;
                ans = (long)Math.abs((arr[2])-arr[1]);
                ans+=ans;
                if(arr[2]!=arr[1])
                    ans-=2;
            }
            else if(arr[1]==arr[2])
            {
                int operator = 0;
                if(arr[0]<arr[1])
                    operator = 1;
                else
                    operator = -1;
                arr[0]+=operator;
                ans = (long)Math.abs((arr[0])-arr[1]);
                ans+=ans;
                if(arr[0]!=arr[1])
                    ans-=2;
            }
            else
            {
                arr[0]+=1;
                arr[2]-=1;
                ans += (long)Math.abs(arr[0]-arr[1]);
                ans += (long)Math.abs(arr[2]-arr[1]);
                ans += (long)Math.abs(arr[0]-arr[2]);
            }
            System.out.println(ans);
        }
    }
}
