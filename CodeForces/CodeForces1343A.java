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
 
public class CodeForces1343A
{
    
    public static long arr[] = new long[30];
    
    public static void main(String[] args) throws Exception
    {
        build();
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
    
    public static void build()
    {
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++)
            arr[i] = 2L * arr[i - 1];
        for(int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
//        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static long solve(int t)
    {
//        for(int i = arr.length - 1; i >=0; i--)
        for(int i = 1; i < arr.length; i++)
        {
            if(t % arr[i] == 0)
                return t / arr[i];
        }
        return t;
    }
    
}

