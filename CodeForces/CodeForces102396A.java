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
        int arr[] = new int[3];
        arr[0] = puttingvaluesinside.nextInt();
        arr[1] = puttingvaluesinside.nextInt();
        arr[2] = puttingvaluesinside.nextInt();
        java.util.Arrays.sort(arr);
        System.out.println(2* (arr[1] - arr[0]) + arr[2] - arr[1]);
    }
}
