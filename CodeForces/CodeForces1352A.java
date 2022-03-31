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
 
public class CodeForces1352A
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0)
        {
            int n = sc.nextInt();
            char c[] = (""+n).toCharArray();
            String s = "";
            int count = 0;
            for(int i = 1, j = c.length - 1; j >= 0; i *= 10, j--)
            {
                if(c[j] == '0') continue;
                s += " "+ (i * (c[j] - '0'));
                count++;
            }
            System.out.println(count);
            System.out.println(s.trim());
        }
    }
}
