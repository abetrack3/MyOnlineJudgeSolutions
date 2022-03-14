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
 
public class CodeForces1324A
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int c = puttingvaluesinside.nextInt();
            boolean odd = false;
            boolean even = false;
            while(c-->0)
            {
                int a = puttingvaluesinside.nextInt();
                if(a%2==0) even = true;
                else odd = true;
            }
//            System.out.println("even = " + even);
//            System.out.println("odd = " + odd);
            if(odd == even)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
