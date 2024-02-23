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
    public static int minute;
    public static int hour;
    public static Scanner puttingvaluesinside;
    
    public static void main(String[] args)
    {
        puttingvaluesinside = new Scanner(System.in);
        while(input())
        {
            hour%=12;
            double convertedHour = 5*6*hour+0.5*minute;
            int convertedMinute = 6*minute;
            double angle = Math.abs(convertedHour-convertedMinute);
            System.out.printf("%.3f\n",((angle<=180.0)?angle:360.0-angle));
        }
    }
    
    public static boolean input()
    {
        String s[] = puttingvaluesinside.nextLine().split(":");
        hour = Integer.parseInt(s[0]);
        minute = Integer.parseInt(s[1]);
        return !(hour==0&&minute==0);
    }
    
}
