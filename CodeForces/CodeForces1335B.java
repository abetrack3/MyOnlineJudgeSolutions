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
 
public class CodeForces1335B
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int q = puttingvaluesinside.nextInt();
        while (q-->0)
        {
            int n = puttingvaluesinside.nextInt();
            int a = puttingvaluesinside.nextInt();
            int b = puttingvaluesinside.nextInt();
            System.out.println(solve(n, a, b));
        }
    }
    
    public static String solve(int n, int a, int b)
    {
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i = 0; i < n; i++)
            sb.append(""+(char)(97+i%b));
        return sb.toString();
    }
    
}
