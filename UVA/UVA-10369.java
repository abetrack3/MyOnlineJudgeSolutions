/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;


public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while (test --> 0)
        {
            int satelliteCount = sc.nextInt();
            int nodeCount = sc.nextInt();
            double g[][] = new double[nodeCount][nodeCount];
            int y[] = new int[nodeCount];
            int x[] = new int[nodeCount];
            for(int i = 0; i < g.length; i++)
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
            solve(g, satelliteCount);
        }
    }
    
    public static void solve(double g[][], int satelliteCount)
    {
        double key[] = new double[g.length];
        int backTrack[] = new int[g.length];
        mstPrim(g, key, backTrack);
        HashSet <Integer> nodes = new HashSet<Integer>();
        PriorityQueue <Edge> edges = new PriorityQueue<Edge>(
            new Comparator<Edge>(){
                public int compare(Edge x, Edge y){
                    double a = x.weight;
                    double b = y.weight;
                    return (a == b) ? 0 : (b > a) ? 1 : -1;
                }});
        for(int i = 1; i < backTrack.length; i++)
            edges.add(new Edge(i, backTrack[i], key[i]));
//        if(satelliteCount < 2) //corner case
//            System.out.printf("%.2f\n", edges.poll().weight);
        double ans = 0;// = edges.poll().weight;
        while (satelliteCount --> 0)
            ans = edges.poll().weight;
        System.out.printf("%.2f\n", ans);
    }
    
    public static void mstPrim(double g[][], double key[], int backTrack[])
    {
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Double.MAX_VALUE);
        java.util.Arrays.fill(backTrack, -1);
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
            if(key[current] == Double.MAX_VALUE) key[current] = 0;
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
    
    static class Edge
    {
        int from;
        int to;
        double weight;
        Edge(int f, int t, double w)
        {
            from = f;
            to = t;
            weight = w;
        }
    }
    
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
}
