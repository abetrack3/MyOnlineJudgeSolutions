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
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Double> cache = new ArrayList<Double>();
        cache.add(0.0);
        for(int i = 1; true; i++)
        {
            cache.add(1.0/(1.0+i) + cache.get(i - 1));
            if(cache.get(cache.size()-1) > 5.20) break;
        }
//        System.out.println("cache.get(cache.size()-1) = " + cache.get(cache.size()-1));
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        while (x != 0.00)
        {
            for(int i = 1; i < cache.size(); i++)
            {
                if(x < cache.get(i))
                {
                    System.out.println(i+" card(s)");
                    break;
                }
            }
            x = sc.nextDouble();
        }
    }
}
