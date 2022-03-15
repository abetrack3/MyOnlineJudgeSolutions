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
 
public class CodeForces1325A
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int x = puttingvaluesinside.nextInt();
            if(x == 2)
                System.out.println("1 1");
            else
                System.out.println("1 "+(x-1));
        }
    }
}
