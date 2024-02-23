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
import java.util.HashSet;

public class Main
{
    
    public static StringBuilder sb;
    
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        while (puttingvaluesinside.hasNext())
        {
            String s = puttingvaluesinside.next();
            int limit = Integer.parseInt(puttingvaluesinside.next());
            solve(s, limit);
        }
    }
    
    public static void solve(String s, int limit)
    {
        char c[] = s.toCharArray();
        java.util.Arrays.sort(c);
        sb = new StringBuilder();
        permute("", c, limit, 0, 0);
        System.out.print(sb);
    }
    
    public static void permute(String s, char c[], int limit, int depth, int index)
    {
        if(depth == limit)
        {
            sb.append(s+"\n");
            return;
        }
        HashSet <String> characters = new HashSet<String>();
        for(int i = index; i < c.length; i++)
        {
            if(characters.contains(""+c[i]))
                continue;
            else
            {
                characters.add(""+c[i]);
                permute(s + c[i], c, limit, depth + 1, i + 1);
            }
        }
    }
    
}
