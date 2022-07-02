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
        int s = puttingvaluesinside.nextInt(),
            x = puttingvaluesinside.nextInt();
        int count = 0;
        while (s != 0)
        {
            s /= x;
            count++;
        }
        System.out.println(count);
    }
}