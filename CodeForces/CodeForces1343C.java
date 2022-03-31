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
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class CodeForces1343C
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
            ArrayList<PriorityQueue<Integer>> sets = new ArrayList<PriorityQueue<Integer>>();
            int t = puttingvaluesinside.nextInt();
            int a = puttingvaluesinside.nextInt();
            t--;
            boolean neg = a < 0;
            sets.add(new PriorityQueue<Integer>((x, y) -> y - x)); //lambda expression
            sets.get(0).add(a);
            while (t-->0)
//            for(int i = 1; i <= t; i++)
            {
                a = puttingvaluesinside.nextInt();
                if( (a < 0 & neg) || (a >= 0 & !neg) ) //same sign
                {
                    sets.get(sets.size() - 1).add(a);
                }
                else if( (a >= 0 & neg) || (a < 0 & !neg) ) //opposite sign
                {
                    sets.add(new PriorityQueue<Integer>((x, y) -> y - x));
                    sets.get(sets.size() - 1).add(a);
                    neg = !neg;
                }
            }
            long ans = 0;
            for(PriorityQueue x : sets)
                ans += (int)x.peek();
            System.out.println(ans);
        }
    }
    
}

