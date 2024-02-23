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
import java.util.ArrayList;
import java.util.BitSet;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader sc = new Reader();
        int nodeCount = sc.nextInt();
        int edges = sc.nextInt();
        while (!(nodeCount == 0 & edges == 0))
        {
            //build graph
            MyGraph G = new MyGraph(nodeCount);
            BitSet weights = new BitSet();
            for(int i = 0; i < edges; i++)
            {
                int f = sc.nextInt();
                int t = sc.nextInt();
                int w = sc.nextInt();
                G.addEdge(f, t, w);
                G.addEdge(t, f, w);
                weights.set(w);
            }
            
            //build spanning tree
            long tree[] = mstPrim(G);
            
            //removing used edges from the edge set, only the unused remains
            for(long x : tree)
                weights.clear((int)x);
            
            //if there exist at least one edge that is unused
            if(weights.cardinality() != 0)
            {
                StringBuilder sb = new StringBuilder();
                int i = weights.nextSetBit(0);
                sb.append(i);
                i = weights.nextSetBit(i + 1);
                for(; i != -1; i = weights.nextSetBit(i + 1))
                    sb.append(" "+i);
                System.out.println(sb);
            } else System.out.println("forest"); //originally a mst
            
            //next test case
            nodeCount = sc.nextInt();
            edges = sc.nextInt();
        }
    }
    
    public static long[] mstPrim(MyGraph G)
    {
        long key[] = new long[G.nodes.length];
        boolean keySet[] = new boolean[key.length];
        java.util.Arrays.fill(key, Long.MAX_VALUE);
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer x, Integer y)
                    {
                        long a = key[x];
                        long b = key[y];
                        return (a == b) ? 0 : (a < b) ? -1 : 1;
                    }
                });
        key[0] = 0;
        keySet[0] = true;
        for(int i = 0; i < key.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            if(key[current] == Long.MAX_VALUE) key[current] = 0;
            keySet[current] = true;
            int l = G.nodes[current].size();
            for(int i = 0; i < l; i++)
            {
                int t = G.nodes[current].get(i).to;
                int w = G.nodes[current].get(i).weight;
                if(!keySet[t] & w < key[t])
                {
                    queue.remove(t);
                    key[t] = w;
                    queue.add(t);
                }
            }
            
        }
        return key;
    }
    
    static class MyGraph
    {
        ArrayList<Edge> nodes[];
        MyGraph(int size)
        {
            nodes = new ArrayList[size];
            for(int i = 0; i < size; i++)
                nodes[i] = new ArrayList<Edge>();
        }
        void addEdge(int f, int t, int w)
        {
            nodes[f].add(new Edge(t, w));
        }
    }
    
    static class Edge
    {
        int to;
        int weight;
        Edge(int t, int w)
        {
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
