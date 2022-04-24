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
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        puttingvaluesinside.nextLine();
        while(t-->0)
        {
            char c[] = puttingvaluesinside.nextLine().toCharArray();
            boolean flag = true;
//            int counter[] = new int[26];
//            for(char x:c)
//                counter[(int)x-'a']++;
//            int count = 0;
            Arrays.sort(c);
            for(int i=1;i<c.length;i++)
            {
                if(c[i]-c[i-1]!=1)
                {
                    flag = false;
                    break;
                }
            }
            System.out.println((flag)?"Yes":"No");
        }
    }
}
