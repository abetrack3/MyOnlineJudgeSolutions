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
 
public class CodeForces1307A
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            int d = puttingvaluesinside.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<arr.length;i++)
                arr[i] = puttingvaluesinside.nextInt();
            for(int i=1;i<arr.length;i++)
            {
                while(arr[i]>0)
                {
                    if(d>=i)
                    {
                        d-=i;
                        arr[0]++;
                        arr[i]--;
                    }
                    else break;
                }
            }
            System.out.println(arr[0]);
        }
    }
}
