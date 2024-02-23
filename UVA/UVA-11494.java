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
        int x1 = puttingvaluesinside.nextInt();
        int y1 = puttingvaluesinside.nextInt();
        int x2 = puttingvaluesinside.nextInt();
        int y2 = puttingvaluesinside.nextInt();
        while(!(x1==0&&y1==0&&x2==0&&y2==0))
        {
            if(x1==x2&&y1==y2)
                System.out.println(0);
            else
            {
                int positiveC = y1-x1;
                int negativeC = y1+x1;
                if(y2==x2+positiveC||y2==-x2+negativeC||x1==x2||y1==y2)
                    System.out.println(1);
                else
                    System.out.println(2);
            }
            x1 = puttingvaluesinside.nextInt();
            y1 = puttingvaluesinside.nextInt();
            x2 = puttingvaluesinside.nextInt();
            y2 = puttingvaluesinside.nextInt();
        }
    }
}
