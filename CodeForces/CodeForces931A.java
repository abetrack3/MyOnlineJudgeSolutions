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
        int a = puttingvaluesinside.nextInt();
        int b = puttingvaluesinside.nextInt();
        int diff = (int)Math.abs(a-b);
        int step = diff/2;
        step*=step+1;
        if(diff%2==1)
            step+=diff/2+1;
        System.out.println(step);
    }
}
