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
 
public class CodeForces1352F
{
    
    public static int zero, one, two;
    public static ArrayList<Integer>arr;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0)
        {
            zero = sc.nextInt(); one = sc.nextInt(); two = sc.nextInt();
            arr = new ArrayList<Integer>();
            addZero();
            addOne();
            addTwo();
            for(int x : arr) System.out.print(x);
            System.out.println();
        }
    }
    
    public static void addZero()
    {
        if(zero == 0) return;
        arr.add(0);
        arr.add(0);
        while (0 <-- zero)
            arr.add(0);
    }
    
    public static void addOne()
    {
        if(one == 0) return;
        arr.add(1);
        if(arr.size() == 1) arr.add(0);
        while(0 <-- one)
        {
            if(arr.get(arr.size() - 1) == 0) arr.add(1);
            else arr.add(0);
        }
    }
    
    public static void addTwo()
    {
        if(two == 0) return;
        if(arr.size() == 0) arr.add(1);
        while (two -- > 0)
        {
            if(arr.get(arr.size()-1)==1) arr.add(1);
            else arr.add(arr.size()-1, 1);
        }
    }
    
}

