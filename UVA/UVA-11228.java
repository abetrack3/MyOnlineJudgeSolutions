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
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

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
        Reader sc = new Reader();
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++)
        {
            int coordinateSize = sc.nextInt();
            int threshold = sc.nextInt();
            int x[] = new int[coordinateSize];
            int y[] = new int[coordinateSize];
            double graph[][] = new double[coordinateSize][coordinateSize];
            x[0] = sc.nextInt();
            y[0] = sc.nextInt();
            for(int j = 1; j < coordinateSize; j++)
            {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
                for(int k = 0; k < j; k++)
                    graph[j][k] = graph[k][j] = Math.sqrt
                        (
                            (x[j]-x[k])*(x[j]-x[k])+(y[j]-y[k])*(y[j]-y[k])
                        );
                    
            }
            System.out.print("Case #"+i+": ");
            mstPrim(graph, threshold);
        }
        
    }
    
    public static void mstPrim(double G[][], int threshold)
    {
        key = new double[G.length];
        keySet = new boolean[G.length];
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                public int compare(Integer x, Integer y)
                {
                    int c = x;
                    int d = y;
                    double ans = key[d] - key[c];
                    return (ans < 0)? 1 : (ans > 0)? -1 : 0;
                }
            });
        Arrays.fill(key, Double.MAX_VALUE);
        Arrays.fill(keySet, true);
        key[0] = 0;
        for(int i = 0; i < key.length; i++)
            queue.add(i);
        while (queue.size() != 0)
        {
            int u = queue.poll();
            keySet[u] = false;
            double edges[] = G[u];
            int size = edges.length;
            for(int i = 0; i < size; i++)
            {
                if(u == i) continue;
                int v = i;
                double w = G[u][v];
                if(keySet[v] & w < key[v])
                {
                    queue.remove(v);
                    key[v] = w;
                    queue.add(v);
                }
            }
        }
        int numberOfCities = 1;
        double roadSum = 0;
        double thresholdSum = 0;
        for(double x : key)
        {
            if(x > threshold)
            {
                numberOfCities++;
                thresholdSum += x;
            }
            else
                roadSum += x;
        }
        long a = Math.round(roadSum);
        long b = Math.round(thresholdSum);
        System.out.println(numberOfCities+" "+a+" "+b);
        
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
