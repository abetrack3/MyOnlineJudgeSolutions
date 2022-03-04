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
import java.lang.StringBuilder;
 
public class CodeForces1295A
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            if(n%2==0)
            {
                n/=2;
//                String s = "";
                StringBuilder sb = new StringBuilder();
                while(n-->0)
                    sb.append('1');
//                    s+="1";
                System.out.println(sb);
            }
            else
            {
//                String s = "7";
                StringBuilder sb = new StringBuilder();
                sb.append('7');
                n-=3;
                n/=2;
                while(n-->0)
                    sb.append('1');
//                    s+="1";
                System.out.println(sb);
            }
        }
    }
}
