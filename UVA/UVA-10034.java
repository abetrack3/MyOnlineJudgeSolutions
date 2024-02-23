/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main
{
    
    public static double key[];
    public static boolean keySet[];
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Scanner puttingvaluesinside = new Scanner(System.in);//(new File("ProblemAInput.txt"));
        int q = puttingvaluesinside.nextInt();
        boolean first = true;
        while (q --> 0)
        {
            puttingvaluesinside.nextLine();
            puttingvaluesinside.nextLine();
            int t = puttingvaluesinside.nextInt();
            double x[] = new double[t];
            double y[] = new double[t];
            for(int i = 0; i < t; i++)
            {
                double x0 = 0.000000001;
                x0 += puttingvaluesinside.nextDouble();
                x[i] = x0;
                double y0 = 0.000000001;
                y0 += puttingvaluesinside.nextDouble();
                y[i] = y0;
            }
            MyGraphDouble G = new MyGraphDouble(t);
            for(int from = 0; from < t - 1; from++)
            {
                for(int to = from + 1; to < t; to++)
                {
                    double weight = Math.sqrt
                    (
                            (x[from] - x[to])*(x[from] - x[to])
                                    +
                            (y[from] - y[to])*(y[from] - y[to])
                    );
                    G.addEdge(from, to, weight);
                    G.addEdge(to, from, weight);
                }
            }
            if(first)
            {
                System.out.printf("%.2f\n", mstPrim(G));
                first = false;
            }
            else
                System.out.printf("\n%.2f\n", mstPrim(G));
        }
    }
    
    public static double mstPrim(MyGraphDouble G)
    {
        key = new double[G.nodes.size()];
        keySet = new boolean[G.nodes.size()];
        PriorityQueue <Long> queue = new PriorityQueue<Long>(
                new Comparator<Long>()
                {
                    public int compare(Long x, Long y)
                    {
                        long a = x;
                        long b = y;
                        int c = (int)a;
                        int d = (int)b;
//                        return (int)(key[d] - key[c]);
                        double ans = key[d] - key[c];
                        return (ans < 0)? 1 : (ans > 0)? -1 : 0;
                    }
                }
        );
        java.util.Arrays.fill(key, Double.MAX_VALUE);//might also use Long.MAX_VALUE
        java.util.Arrays.fill(keySet, true);
        key[0] = 0;
//        keySet[0] = false;
        for(long i = 0; i < key.length; i++)
            queue.add(i);
        while (queue.size() != 0)
        {
            int u = (int)((long)queue.poll());//.peek());
            keySet[u] = false;
            GraphNodeDouble nodeU = G.nodes.get(u);
            int size = nodeU.edges.size();
            for(int i = 0; i < size; i++)
            {
                int v = nodeU.edges.get(i);
                double w = nodeU.weights.get(i);
                if(keySet[v] & w < key[v])
                {
                    queue.remove((long)v);
                    key[v] = w;
                    queue.add((long)v);
                }
            }
//            queue.poll();
//            keySet[u] = false;
        }
        double sum = 0;
        for(double x : key)
            sum += x;
        return sum;
    }
    
}

class MyGraphDouble
{
    ArrayList <GraphNodeDouble> nodes = new ArrayList<GraphNodeDouble>();
    
    MyGraphDouble(int size)
    {
        while (size --> 0)
            nodes.add(new GraphNodeDouble());
    }
    
    void addEdge(int from, int to, double weight)
    {
        GraphNodeDouble n = nodes.get(from);
        n.edges.add(to);
        n.weights.add(weight);
    }
    
}

class GraphNodeDouble
{
    
    ArrayList <Integer> edges = new ArrayList<Integer>();
    ArrayList <Double> weights = new ArrayList<Double>();
    
}
