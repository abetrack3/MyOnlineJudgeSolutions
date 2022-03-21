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
 
public class CodeForces1352G
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0)
        {
            int n = sc.nextInt();
            if(n == 2 || n == 3)
            {
                System.out.println(-1);
                continue;
                
            }
            else if(n == 4) System.out.println("2 4 1 3");
            else if(n == 5) System.out.println("1 3 5 2 4");
            else if(n == 6) System.out.println("2 4 6 3 5 1");
            if(n <= 6) continue;
            int f = (n%2==0)?2:1;
            int i = 0;
            for(; i*2+f <= n; i++)
                System.out.print(((i > 0)?" ":"")+(i*2+f));
            i--;
            int k = i*2+f - 3;
            System.out.print(" "+k);
            k += 2;
            System.out.print(" "+k);
            k -= 4;
            System.out.print(" "+k);
            k -= 2;
            while (k >= 1)
            {
                System.out.print(" "+k);
                k -= 2;
            }
            System.out.println();
        }
    }
}
