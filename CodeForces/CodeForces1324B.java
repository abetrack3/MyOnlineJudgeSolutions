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
 
public class CodeForces1324B
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            boolean flag = false;
            int arr[] = new int[n];
            int first[] = new int[n+1];
            Arrays.fill(first, -1);
            for(int i = 0 ; i<arr.length ; i++)
            {
                int a = puttingvaluesinside.nextInt();
                arr[i] = a;
                if(first[a] == -1)
                    first[a] = i;
            }
            for(int i=arr.length-1;i>=0;i--)
            {
                int firstIndex = first[arr[i]];
                int diff = (int)Math.abs(i-firstIndex);
                if(diff>=2)
                {
                    flag = true;
                    break;
                }
            }
            System.out.println((flag)?"YES":"NO");
//            System.out.println("Arrays.toString(first) = " + Arrays.toString(first));
        }
    }
}
