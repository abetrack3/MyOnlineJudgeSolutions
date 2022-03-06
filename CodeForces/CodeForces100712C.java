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

public class CodeForces100712C
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int test = puttingvaluesinside.nextInt();
        while (test --> 0)
        {
            puttingvaluesinside.nextInt();
            puttingvaluesinside.nextLine();
            char c[] = puttingvaluesinside.nextLine().toCharArray();
            boolean lightLit[] = new boolean[c.length];
            for (int i = 0; i < c.length; i++)
            {
                if (c[i] == '*')
                {
                    lightLit[i] = true;
                    if(i != 0) lightLit[i - 1] = true;
                    if(i != c.length - 1) lightLit[i + 1] = true;
                }
            }
            
            int count = 0;
            // 3 Blocks in a row not lit
            for (int i = 2; i < c.length; i++)
            {
                if(!lightLit[i] & !lightLit[i - 1] & !lightLit[i - 2])
                {
                    lightLit[i] = lightLit[i - 1] = lightLit[i - 2] = true;
                    count++;
                }
            }
            
            // 2 Blocks in a row not lit
            for (int i = 1; i < c.length; i++)
            {
                if(!lightLit[i] & !lightLit[i - 1])
                {
                    lightLit[i] = lightLit[i - 1] = true;
                    count++;
                }
            }
            
            // 1 Blocks in a row not lit
            for (int i = 0; i < c.length; i++)
            {
                if(!lightLit[i])
                {
                    lightLit[i] = true;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

