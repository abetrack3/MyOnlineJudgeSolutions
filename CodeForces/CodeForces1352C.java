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
 
public class CodeForces1352C
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t --> 0)
        {
            int n = sc.nextInt(), k = sc.nextInt();
            int ans = k;
            int multiples = 0;
            while (ans/n != multiples)
            {
                int temp = ans/n - multiples;
                multiples = ans/n;
                ans += temp;
            }
            System.out.println(ans);
        }
    }
}
