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
import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
        {
            int limit = sc.nextInt();
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();
            HellPermutation hp = new HellPermutation(arr, n, limit);
            hp.permute();
            System.out.println(hp);
        }
    }
    
}

class HellPermutation
{
    
    int arr[];
    int n;
    int limit;
    String chosen;
    int sum;
    boolean flag = true;
    
    HellPermutation(int a[], int nn, int l)
    {
        arr = a;
        n = nn;
        limit = l;
        chosen = "";
        sum = 0;
    }
    
    public void permute()
    {
        permute(0, 0, "");
        if(sum == 0) chosen = arr[0] + " ";
    }
    
    private void permute(int index, int sum, String s)
    {
        if(index == n || index == 20) return;
        else
        {
            HashSet <Integer> unique = new HashSet<Integer>();
            for(int i = index; i < arr.length && flag; i++)
            {
                if(unique.contains(arr[i])) continue;
                else
                {
                    unique.add(arr[i]);
                    int newsum = sum + arr[i];
                    String news = s + arr[i] + " ";
                    if(newsum == limit)
                    {
                        this.sum = newsum;
                        this.chosen = news;
                        flag = false;
                        return;
                    }
                    else if(newsum > limit) continue;
                    else if(newsum > this.sum && newsum <= this.limit)
                    {
                        this.sum = newsum;
                        this.chosen = news;
                        permute(i + 1, newsum, news);
                    }
                    else permute(i + 1, newsum, news);
                }
            }
        }
    }
    
    public String toString()
    {
        return chosen+"sum:"+sum;
    }
    
}
