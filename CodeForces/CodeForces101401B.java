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
 
public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        String s = puttingvaluesinside.nextLine();
//        System.out.println("s = " + s);
        System.out.println(optimal2(s));
        
    }
    
    public static void cumulative(char c[], int arr[])
    {
        for (int i = c.length - 2; i >= 0; i--)
        {
            if(c[i] == ':' & c[i + 1] == ')')
                arr[i]++;
            arr[i] += arr[i + 1];
        }
    }
    
    public static int optimal(String s)
    {
        char c[] = s.toCharArray();
        String s2 = new StringBuilder(s).reverse().toString();
        char c2[] = s2.toCharArray();
        for(int i = 0; i < c.length; i++)
            if(c2[i] == '(') c2[i] = ')';
            else if(c2[i] == ')') c2[i] = '(';
        int forward[] = new int[c.length];
        int backward[] = new int[c.length];
        cumulative(c, forward);
        cumulative(c2, backward);
//        System.out.println(java.util.Arrays.toString(c));
//        System.out.println(java.util.Arrays.toString(forward));
//        System.out.println(java.util.Arrays.toString(c2));
//        System.out.println(java.util.Arrays.toString(backward));
        int max = Math.max(backward[0], forward[0]);
        for(int i = 1, j = c.length - 1; i < c.length; i++, j--)
        {
            int temp = forward[i] + backward[j];
            if(c[i] == ')' & c2[i - 1] == ':') temp--;
            if(c[i] == ')' & c[0] == ':') temp++;
            max = Math.max(max, temp);
        }
        return max;
    }
    
    public static int optimal2(String s)
    {
        char c[] = s.toCharArray();
        int left[] = new int[c.length];
        int right[] = new int[c.length];
        
        //left
        for(int i = 1; i < c.length; i++)
            if(c[i] == ':' & c[i - 1] == '(') left[i] = 1 + left[i - 1];
            else left[i] = left[i - 1];
        
        //right
        for(int i = c.length - 2; i >=0 ; i--)
            if(c[i] == ':' & c[i + 1] == ')') right[i] = 1 + right[i + 1];
            else right[i] = right[i + 1];
        
        int max = Math.max(left[c.length - 1], right[0]);
        for(int i = 1; i < c.length - 1; i++)
        {
            int temp = left[i - 1] + right[i];
            if(c[i] == ')')
            {
//                if(c[i - 1] == ':') temp--;
                if(c[0] == ':') temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
    
    public static int bruteForce(String s) //requires flipping
    {
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int arr[] = new int[s.length()];
            String ss = new StringBuilder(s.substring(0, i)).reverse().toString();
            
            ss += s.substring(i, s.length());
            System.out.println("ss = " + ss);
            cumulative(ss.toCharArray(), arr);
            max = Math.max(max, arr[0]);
        }
        return max;
    }
    
}