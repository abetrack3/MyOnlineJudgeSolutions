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
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main
{
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        while (sc.hasNextInt())
        {
            int nodes = sc.nextInt();
            int x[] = new int[nodes];
            int y[] = new int[nodes];
            double g[][] = new double[nodes][nodes];
            for(int i = 0; i < nodes; i++)
            {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                for(int j = 0; j < i; j++)
                {
                    g[i][j] = g[j][i] = Math.sqrt
                    (
                        (x[i] - x[j]) * (x[i] - x[j])
                            +
                        (y[i] - y[j]) * (y[i] - y[j])
                    );
                }
            }
            int q = sc.nextInt();
            while (q --> 0)
            {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                g[from][to] = g[to][from] = 0;
            }
            System.out.printf("%.2f\n", mstPrim(g));
        }
    }
    
    public static double mstPrim(double g[][])
    {
        double key[] = new double[g.length];
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Double.MAX_VALUE);
        key[0] = 0;
        keySet[0] = true;
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    double a = key[x];
                    double b = key[y];
                    return (a == b) ? 0 : (b > a) ? -1 : 1;
                }});
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            keySet[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(!keySet[i] & g[current][i] < key[i])
                {
                    queue.remove(i);
                    key[i] = g[current][i];
                    queue.add(i);
                }
            }
        }
        double sum = 0;
        for(double x : key)
            sum += x;
        return sum;
    }
    
}
