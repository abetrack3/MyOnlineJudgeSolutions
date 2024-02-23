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
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
//        Reader sc = new Reader("ProblemDInput.txt");
        Reader sc = new Reader();
        StringBuilder sb = new StringBuilder();
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++)
        {
            int nodeCount = sc.nextInt();
            int edgeCount = sc.nextInt();
            int airPortCost = sc.nextInt();
            ArrayList<edge> edges = new ArrayList<edge>();
            while (edgeCount --> 0)
            {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                int weight = sc.nextInt();
                if(weight >= airPortCost) continue;
                edges.add(new edge(from, to, weight));
            }
            sb.append("Case #"+i+": "+mstKruskal(edges, nodeCount, airPortCost)+"\n");
//            System.out.println("Case #"+i+": "+mstKruskal(edges, nodeCount, airPortCost));
        }
        System.out.print(sb);
    }
    
    public static String mstKruskal(ArrayList<edge>edges, int nodeCount, int airPortCost)
    {
        Collections.sort(edges);
        int backTrack[] = new int[nodeCount];
        for(int i = 0; i < nodeCount; i++)
            backTrack[i] = i;
        long sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        while (i < edges.size())
        {
            edge e = edges.get(i++);
            int subsetFrom = find(backTrack, e.from);
            int subsetTo = find(backTrack, e.to);
            if(subsetFrom != subsetTo)
            {
                sum += e.weight;
                union(backTrack, e.from, e.to);
            }
        }
        for(int j = 0; j < nodeCount; j++)
            set.add(find(backTrack, j));
        sum += airPortCost * set.size();
        return sum + " " + set.size();
    }
    
    public static int find(int backTrack[], int node)
    {
        if(backTrack[node] == node) return node;
        return backTrack[node] = find(backTrack, backTrack[node]);
    }
    
    public static void union(int backTrack[], int nodeA, int nodeB)
    {
        int x1 = find(backTrack, nodeA);
        int x2 = find(backTrack, nodeB);
        backTrack[x2] = x1;
    }
    
    static class edge implements Comparable<edge>
    {
        int from, to, weight;
        edge(int f, int t, int w)
        {
            from = f;
            to = t;
            weight = w;
        }
        
        public int compareTo(edge x)
        {
            return (weight == x.weight) ? 0 : (weight < x.weight) ? -1 : 1;
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
