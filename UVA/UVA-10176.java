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
//This is cheating though :3
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder bin = new StringBuilder();
        while (sc.hasNextLine())
        {
            String in = sc.nextLine();
            if (in.charAt(in.length()-1) == '#')
            {
                int result = 0;
                bin.append(in);
                bin.deleteCharAt(bin.length()-1);
                int p = 1;
                for (int i = bin.length()-1; i >= 0; i--)
                {
                    result += (bin.charAt(i) - '0')*p;
                    result %= 131071;
                    p *= 2;
                    p %= 131071;
                }
                if(result == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
                
                bin = new StringBuilder();
            }
            else
                bin.append(in);
        }
    }
}
