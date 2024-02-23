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

public class Main
{
    
    public static Reader sc;
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        sc = new Reader();
        int corner = sc.nextInt();
        int street = sc.nextInt();
        int query = sc.nextInt();
        int test = 1;
        while (true)
        {
            int g[][] = new int[corner][corner];
            while(street --> 0)
            {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                g[from][to] = g[to][from] = sc.nextInt();
            }
            System.out.println("Case #"+test++);
            solve(g, query);
            
            corner = sc.nextInt();
            street = sc.nextInt();
            query = sc.nextInt();
            if(corner == 0 & street == 0 & query == 0)
                break;
            else
                System.out.println();
        }
    }
    
    public static void solve(int g[][], int query) throws Exception
    {
        int key[] = new int[g.length];
        int backTrack[] = new int[g.length];
        mstPrim(g, key, backTrack);
        int spanningTree[][] = new int[g.length][g.length];
        buildSpanningTree(spanningTree, key, backTrack);
        int ans[][] = new int[g.length][g.length];
        buildCache(spanningTree, ans);
        while (query --> 0)
        {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int temp = ans[from][to];
            if(temp == 0)
            {
                if(from == to) System.out.println(0);
                else System.out.println("no path");
            } else System.out.println(temp);
        }
//        System.out.println();
    }
    
    public static void mstPrim(int g[][], int key[], int backTrack[])
    {
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Integer.MAX_VALUE);
        java.util.Arrays.fill(backTrack, -1);
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
                if(g[current][i] == 0) continue; //assuming no zero weights will be given
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
    
    public static void buildSpanningTree(int g[][], int key[], int backTrack[])
    {
        for(int i = 0; i < g.length; i++)
        {
            if(backTrack[i] == -1) continue;
            int from = i;
            int to = backTrack[i];
            int weight = key[i];
            g[from][to] = g[to][from] = weight;
        }
    }
    
    public static void buildCache(int g[][], int cache[][])
    {
        for(int i = 0; i < g.length; i++)
            bfs(g, cache[i], i);
    }
    
    public static void bfs(int g[][], int cache[], int start)
    {
        boolean visited[] = new boolean[g.length];
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> maxWeight = new ArrayList<Integer>();
        visited[start] = true;
        queue.add(start);
        maxWeight.add(0);
        while (!queue.isEmpty())
        {
            int current = queue.remove(0);
            int currentMaxWeight = maxWeight.remove(0);
            visited[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(i == current) continue;
                if(visited[i]) continue;
                if(g[current][i] == 0) continue;
                queue.add(i);
                visited[i] = true;
                int temp = Math.max(currentMaxWeight, g[current][i]);
                cache[i] = temp;
                maxWeight.add(temp);
            }
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
