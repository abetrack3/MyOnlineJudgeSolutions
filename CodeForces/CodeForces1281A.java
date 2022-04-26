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
        puttingvaluesinside.nextLine();
        while(t-->0)
        {
            String s = puttingvaluesinside.nextLine();
            if(s.endsWith("po"))
                System.out.println("FILIPINO");
            else if(s.endsWith("desu")||s.endsWith("masu"))
                System.out.println("JAPANESE");
            else
                System.out.println("KOREAN");
        }
    }
}
