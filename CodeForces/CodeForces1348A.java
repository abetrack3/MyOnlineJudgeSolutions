/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abetrack3
 */
 
import java.util.Scanner;
 
public class CodeForces1348A
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while (t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            long sum = 2 * (1 - (long)Math.pow(2, n)) / -1;
            int half = n / 2;
            long leftSum = (long)Math.pow(2, n);
            int twos = 2;
            for(int i = 1; i < half; i++)
            {
                leftSum += twos;
                twos *= 2;
            }
            long rightSum = sum - leftSum;
            long diff = Math.abs(leftSum - rightSum);
            System.out.println(diff);
        }
    }
}
