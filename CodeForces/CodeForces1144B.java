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
import java.util.Arrays;

public class Main
{
    
    public static void main(String[] args)
    {
        bruteForce();
    }
    
    public static void bruteForce()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int sum = 0;
        int t = puttingvaluesinside.nextInt();
        int arr[] = new int[t];
        int prevOddArray[] = new int[t];
        Arrays.fill(prevOddArray, -1);
        int prevEvenArray[] = new int[t];
        Arrays.fill(prevEvenArray, -1);
        int evenCount = 0;
        int oddCount = 0;
        int prevOdd = -1;
        int prevEven = -1;
        for(int i=0;i<arr.length;i++)
        {
                arr[i] = puttingvaluesinside.nextInt();
                sum+=arr[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0)
            {
                evenCount++;
                if(evenCount==1)
                    prevEven = i;
                else
                {
                    prevEvenArray[i] = prevEven;
                    prevEven = i;
                }
                    
            }
            else
            {
                oddCount++;
                if(oddCount==1)
                    prevOdd = i;
                else
                {
                    prevOddArray[i] = prevOdd;
                    prevOdd = i;
                }
            }
            
        }
        if(evenCount==oddCount||(int)Math.abs(evenCount-oddCount)==1)
        {
            System.out.println(0);
            return;
        }
        for(int i=(evenCount>oddCount)?prevEven:prevOdd;i>=0;)
        {
            sum-=arr[i];
            if(arr[i]%2==0)
            {
                i=prevOdd;
                prevEven = prevEvenArray[prevEven];
            }
            else
            {
                i = prevEven;
                prevOdd = prevOddArray[prevOdd];
            }
        }
        
        System.out.println(sum);
        
    }
}
