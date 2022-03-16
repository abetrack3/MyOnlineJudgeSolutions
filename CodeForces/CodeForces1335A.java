/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abetrack3
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class CodeForces1335A
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q-->0)
        {
            int t = Integer.parseInt(br.readLine());
            System.out.println(solve(t));
        }
    }
    
    public static int solve(int t)
    {
        if(t == 1 || t == 2) return 0;
        int b = t / 2;
        int a = 0;
        if (!(t % 2 == 0)) a = b + 1;
        else
        {
            a = b;
            a++;
            b--;
        }
        return b;
    }
    
}
