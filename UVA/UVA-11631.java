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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main
{
    
    public static Reader puttingvaluesinside;
    public static long key[];
    public static boolean keySet[];
    
    public static void main(String[] args) throws Exception
    {
        puttingvaluesinside = new Reader();//"ProblemCINput.txt");
        run();
    }
    
    public static void run() throws Exception
    {
        int nodeNo = puttingvaluesinside.nextInt();
        int edgeNo = puttingvaluesinside.nextInt();
        while (nodeNo != 0 & edgeNo != 0)
        {
            System.out.println(solve(nodeNo, edgeNo));
            nodeNo = puttingvaluesinside.nextInt();
            edgeNo = puttingvaluesinside.nextInt();
        }
    }
    
    public static long solve(int node, int edges) throws Exception
    {
        if(node - 1 == edges) return alreadyATree(edges);
        MyGraph G = new MyGraph(node);
        int t = edges;
        long sum = 0;
        while (t --> 0)
        {
            int from = puttingvaluesinside.nextInt();
            int to = puttingvaluesinside.nextInt();
            int weight = puttingvaluesinside.nextInt();
            sum += weight;
            G.addEdge(from, to, weight);
            G.addEdge(to, from, weight);
        }
        long ans = mstPrim(G);
//        System.out.println("ans = " + ans);
        return sum - ans;
    }
    
    public static long mstPrim(MyGraph G)
    {
        key = new long[G.nodes.size()];
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
                        long ans = key[d] - key[c];
                        return (ans < 0)? 1 : (ans > 0)? -1 : 0;
                    }
                }
        );
        java.util.Arrays.fill(key, Long.MAX_VALUE);
        java.util.Arrays.fill(keySet, true);
        key[0] = 0;
//        keySet[0] = false;
        for(long i = 0; i < key.length; i++)
            queue.add(i);
        while (queue.size() != 0)
        {
            int u = (int)((long)queue.poll());//.peek());
            keySet[u] = false;
            GraphNode nodeU = G.nodes.get(u);
            int size = nodeU.edges.size();
            for(int i = 0; i < size; i++)
            {
                int v = nodeU.edges.get(i);
                int w = nodeU.weights.get(i);
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
        long sum = 0;
        for(long x : key)
            sum += x;
        return sum;
    }
    
    public static long alreadyATree(int edges) throws Exception
    {
        while(edges --> 0)
        {
            puttingvaluesinside.nextInt();
            puttingvaluesinside.nextInt();
            puttingvaluesinside.nextInt();
        }
        return 0;
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
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
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

class MyGraph
{
    ArrayList <GraphNode> nodes = new ArrayList<GraphNode>();
    
    MyGraph(int size)
    {
        while (size --> 0)
            nodes.add(new GraphNode());
    }
    
    void addEdge(int from, int to, int weight)
    {
        GraphNode n = nodes.get(from);
        n.edges.add(to);
        n.weights.add(weight);
    }
    
}

class GraphNode
{
    
    ArrayList <Integer> edges = new ArrayList<Integer>();
    ArrayList <Integer> weights = new ArrayList<Integer>();
    
}
