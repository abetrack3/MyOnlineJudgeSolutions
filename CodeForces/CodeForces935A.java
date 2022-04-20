/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18101257
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int n = puttingvaluesinside.nextInt()-1;
        int m = 1;
        int count = 0;
        while(m<=n)
        {
            if(n%m==0)
                count++;
            n--;
            m++;
        }
        System.out.println(count);
    }
}
