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
import java.util.HashSet;
import java.util.Arrays;
 
public class CodeForces1325B
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int n = puttingvaluesinside.nextInt();
            HashSet <Integer> hs = new HashSet<Integer>();
            while(n-->0)
                hs.add(puttingvaluesinside.nextInt());
            System.out.println(hs.size());
        }
    }
}

