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
import java.util.Arrays;

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
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            ArrayList<Integer> g[][] = new ArrayList[nodes][nodes];
            while (edges --> 0)
            {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                int weight = sc.nextInt();
                if(from == to) continue; //discarding self edge
                if(g[from][to] == null)
                    g[from][to] = g[to][from] = new ArrayList<Integer>();
                g[from][to].add(weight);
            }
            solve(g);
        }
    }
    
    public static void solve(ArrayList<Integer> g[][])
    {
        int treeEdge[] = new int[g.length];
        int treeWeights[] = new int[g.length];
        int firstMST = mstPrim(g, treeWeights, treeEdge, -1, -1, -1);
        int secondMST = Integer.MAX_VALUE;
        for(int i = 0; i < g.length; i++)
        {
            if(treeEdge[i] == -1) continue;
            
            //backup to be removed edge
            int from = i;
            int to = treeEdge[i];
            int weight = treeWeights[i];
            
            //we aren't removing edge... just forbidding it
            
            int temp = mstPrim(g, new int[g.length], new int[g.length], from, to, weight);
            if(temp == firstMST){secondMST = temp; break;}
            if(temp < secondMST & temp > firstMST)
                secondMST = temp;
        }
        System.out.println(firstMST + " " + secondMST);
    }
    
    public static int mstPrim(ArrayList<Integer> g[][], int key[], int backTrack[], int f, int t, int w)
    {
        boolean keySet[] = new boolean[g.length];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(backTrack, -1);
        key[0] = 0;
        keySet[0] = true;
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    int a = key[x];
                    int b = key[y];
                    return (a == b) ? 0 : (b > a) ? -1 : 1;
                }});
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            keySet[current] = true;
            if(key[current] == Integer.MAX_VALUE) key[current] = 0;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(g[current][i] == null) continue;
                if(!keySet[i])
                {
                    for(int x : g[current][i])
                    {
                        if(x==w & ((current==f & i==t)|(current==t & f==i)))
                                continue;
                        if(x < key[i])
                        {
                            queue.remove(i);
                            key[i] = x;
                            backTrack[i] = current;
                            queue.add(i);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int x : key)
            ans += x;
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
