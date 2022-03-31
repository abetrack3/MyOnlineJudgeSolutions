/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author abetrack3
 */
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class CodeForces1352B
{
    
    public static ArrayList<Integer> ans;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        while (test --> 0)
        {
            ans = new ArrayList<Integer>();
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n % 2 == 0) even(n, k);
            else odd(n, k);
        }
    }
    
    public static void odd(int n, int k)
    {
        if(k % 2 == 0 || k > n)
        {
            System.out.println("NO");
            return;
        }
        else
        {
            int sum = 0;
            for(int i = 1; i < k; i++)
            {
                ans.add(1);
                sum++;
            }
            ans.add(n - sum);
            System.out.println("YES");
            System.out.print(ans.get(0));
            for(int i = 1; i < ans.size(); i++)
                System.out.print(" "+ans.get(i));
            System.out.println();
        }
        
    }
    
    public static void even(int n, int k)
    {
        if(2*k > n)
        {
            ans.add(1);
            odd(n-1, k-1);
            return;
        }
        int sum = 0;
        for(int i = 1; i < k; i++)
        {
            ans.add(2);
            sum += 2;
        }
        ans.add(n - sum);
        System.out.println("YES");
        System.out.print(ans.get(0));
        for(int i = 1; i < ans.size(); i++)
            System.out.print(" "+ans.get(i));
        System.out.println();
    }
    
}

