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
        int t = puttingvaluesinside.nextInt();
        for(int i = 1;i<=t;i++)
        {
//            String s = "Case "+i+":\n";
            System.out.println("Case "+i+":");
            int x1 = puttingvaluesinside.nextInt();
            int y1 = puttingvaluesinside.nextInt();
            int x2 = puttingvaluesinside.nextInt();
            int y2 = puttingvaluesinside.nextInt();
            int m = puttingvaluesinside.nextInt();
            while(m-->0)
            {
                int x = puttingvaluesinside.nextInt();
                int y = puttingvaluesinside.nextInt();
                if(x>x1&&x<x2&&y>y1&&y<y2)
                    System.out.println("Yes");
//                    s+="YES";
                else
                    System.out.println("No");
//                    s+="NO";
            }
//            System.out.print(s);
        }
    }
}
