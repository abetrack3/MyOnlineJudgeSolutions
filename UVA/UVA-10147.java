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
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        while (test --> 0)
        {
            sc.nextLine();
            int nodeCount = sc.nextInt();
            int x[] = new int[nodeCount];
            int y[] = new int[nodeCount];
            double g[][] = new double[nodeCount][nodeCount];
            for(int i = 0; i < g.length; i++)
            {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                for(int j = 0; j < i; j++)
                    g[i][j] = g[j][i] = calDistance(x[i], x[j], y[i], y[j]);
            }
            int alreadyBuilt = sc.nextInt();
            while (alreadyBuilt --> 0)
            {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                g[a][b] = g[b][a] = 0;
            }
            solve(g);
            if(test != 0) System.out.println();
        }
    }
    
    public static void solve(double g[][])
    {
        double key[] = new double[g.length];
        int backTrack[] = new int[g.length];
        mstPrim(g, key, backTrack);
        edge e[] = new edge[g.length-1];
        for(int i = 1; i < g.length; i++)
            e[i - 1] = new edge(i+1, backTrack[i] + 1, key[i]);
        java.util.Arrays.sort(e);
        boolean flag = true;
        for(int i = 0; i < e.length; i++)
        {
            if(e[i].weight == 0) continue;
            flag = false;
            System.out.println(e[i].from + " " + e[i].to);
        }
        if(flag) System.out.println("No new highways need");
    }
    
    public static void mstPrim(double g[][], double key[], int backTrack[])
    {
        
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Double.MAX_VALUE);
        java.util.Arrays.fill(backTrack, -1);
        key[0] = 0;
        keySet[0] = true;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    double a = key[x];
                    double b = key[y];
                    return (a == b) ? 0 : (b > a) ? -1 : 1;//minimum pops first
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
                    backTrack[i] = current;
                    queue.add(i);
                }
            }
        }
        
    }
    
    public static double calDistance(int x1, int x2, int y1, int y2)
    {
        int dx = x1 - x2;
        int dy = y1 - y2;
        double ans = Math.sqrt(dx*dx + dy*dy);
        return ans;
    }
    
    static class edge implements Comparable<edge>
    {
        int from;
        int to;
        double weight;
        edge(int f, int t, double w)
        {
            if(f > t)
            {
                from = t;
                to = f;
            }
            else
            {
                from = f;
                to = t;
            }
            weight = w;
        }
        
        public int compareTo(edge x)
        {
            if(from == x.from & to == x.to) return 0;
            else if(from == x.from) return (to == x.to)?0 : (to < x.to)?-1 : 1;
            else return (from == x.from)? 0 : (from < x.from)? -1 : 1;
        }
        
    }
    
}
