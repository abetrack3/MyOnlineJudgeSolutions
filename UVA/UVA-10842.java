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

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        for(int t = 1; t <= testCases; t++)
        {
            int nodeCount = sc.nextInt();
            int edges = sc.nextInt();
            int graph[][] = new int[nodeCount][nodeCount];
            while (edges -->0)
            {
                int f = sc.nextInt();
                int t0 = sc.nextInt();
                int w = sc.nextInt();
                graph[f][t0] = graph[t0][f] = Math.max(w, graph[f][t0]);
            }
            int ans = maximumSpanningTreePrim(graph);
            System.out.printf("Case #%d: %d\n", t, ans);
        }
    }
    
    public static int maximumSpanningTreePrim(int g[][])
    {
        int key[] = new int[g.length];
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Integer.MIN_VALUE);
        PriorityQueue<Integer>queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y)
                {
                    int a = key[x];
                    int b = key[y];
                    return (a == b) ? 0 : (a < b) ? 1 : -1;
                }});
        key[0] = Integer.MAX_VALUE;
        keySet[0] = true;
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            //corner case to handle disconnected graph....
            //however even without handling this corner case
            //the code got accepted
            //from this it could be inferred that
            //there is no input test case containing a disconnected graph
//            if(key[current] == Integer.MIN_VALUE) key[current] = Integer.MAX_VALUE;
            keySet[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(g[current][i] == 0) continue;
                if(!keySet[i] & key[i] < g[current][i])
                {
                    queue.remove(i);
                    key[i] = g[current][i];
                    queue.add(i);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int x : key)
            ans = Math.min(ans, x);
        
        //apparently edges that connects itself (e.g 0 0 10) are not considered
        //as part of maximumSpanningTree or at least not in this problem
//        for(int i = 0; i < g.length; i++)
//            if(g[i][i] > 0)
//                ans = Math.min(ans, g[i][i]);
        return ans;
        
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
