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
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int 
                    n = puttingvaluesinside.nextInt(),
                    x = puttingvaluesinside.nextInt(),
                    y = puttingvaluesinside.nextInt();
            System.out.println((y>=n/2&&x>=((n/2)+1))?"YES":"NO");
        }
    }
}
