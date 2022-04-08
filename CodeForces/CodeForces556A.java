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

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        char c[] = puttingvaluesinside.nextLine().toCharArray();
        c = puttingvaluesinside.nextLine().toCharArray();
        int one = 0;
        int zero = 0;
        for(char x:c)
        {
            switch (x)
            {
                case '0' : {zero++; break;}
                case '1' : {one++; break;}
            }
        }
        System.out.println(c.length-2*(int)Math.min(one, zero));
    }
}
