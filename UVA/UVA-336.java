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
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader sc = new Reader();
        int edges = sc.nextInt();
        int testCase = 1;
        while (edges != 0)
        {
            System.gc();
            HashMap <Integer, Integer> label = new HashMap<Integer, Integer>();
            int x[] = new int[edges];
            int y[] = new int[edges];
            for(int i = 0; i < edges; i++)
            {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                if(!label.containsKey(x[i]))
                    label.put(x[i], label.size());
                if(!label.containsKey(y[i]))
                    label.put(y[i], label.size());
            }
            MyGraph G = new MyGraph(label.size(), 2 * edges);
            for(int i = 0 ; i < edges; i++)
            {
                int r = label.get(x[i]);
                int s = label.get(y[i]);
                G.addEdge(r, s, 1);
                G.addEdge(s, r, 1);
            }
            int from = sc.nextInt();
            int to = sc.nextInt();
            while (!(from == 0 & to == 0))
            {
                int ans;
                if(label.containsKey(from))
                    ans = BFS(G, label.get(from), to);
                else ans = label.size();
                System.out.printf
                (
                "Case %d: %d nodes not reachable from node %d with TTL = %d.\n",
                testCase++, ans, from, to
                );
                from = sc.nextInt();
                to = sc.nextInt();
            }
            
            edges = sc.nextInt();
        }
    }
    
    public static int BFS(MyGraph G, int zero, int ttl)
    {
        boolean visited[] = new boolean[G.nodeCount];
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> lifeSpan = new ArrayList<Integer>();
        queue.add(zero);
        lifeSpan.add(ttl);
        visited[zero] = true;
        for(int i = 0; i < queue.size(); i++)
        {
            int current = queue.get(i);
            int remaining = lifeSpan.get(i);
            if(remaining == 0) continue;
            int start = G.nodes[current].start;
            int end = G.nodes[current].end;
            for(int j = start; j <= end; j++)
            {
                int to = G.edges[j].to;
                if(visited[to]) continue;
                queue.add(to);
                lifeSpan.add(remaining - 1);
                visited[to] = true;
            }
        }
        return G.nodeCount - queue.size();
    }
    
    static class MyGraph
    {
        int nodeCount;
        int edgeCount;
        int fillCount; //count of how many edges are added into edges[]
        Comparator <MyEdge> c;
        MyNode nodes[];
        MyEdge edges[];
        
        MyGraph(int n, int e)
        {
            nodeCount = n;
            nodes = new MyNode[n];
            for(int i = 0; i < nodes.length; i++)
                nodes[i] = new MyNode();
            edgeCount = e;
            edges = new MyEdge[e];
            c = new Comparator<MyEdge>()
            {
                public int compare(MyEdge a, MyEdge b)
                {
                    int c = a.from;
                    int d = b.from;
                    return (c == d) ? 0 : (c > d) ? 1 : -1;
                }
            };
        }
        
        public void addEdge(int f, int t, int w)
        {
            MyEdge e = new MyEdge(f, t, w);
            edges[fillCount++] = e;
            heapSwim(edges, fillCount - 1, c);
            if(fillCount == edgeCount)
            {
                sortEdges();
                updateNodeIndices();
            }
        }
        
        public void updateNodeIndices()
        {
            
            for(int i = 0; i < edges.length;)
            {
                int j = i + 1;
                for(; j < edges.length; j++)
                {
                    if(edges[j].from != edges[i].from)
                        break;
                }
                nodes[edges[i].from].start = i;
                nodes[edges[i].from].end = j - 1;
                i = j;
            }
        }
        
        public void sortEdges()
        {
            int size = edges.length;
            while (size --> 0)
            {
                mySwap(edges, 0, size);
                heapSink(edges, 0, c, size);
            }
        }
        
        public static <E> void heapSwim(E e[], int current, Comparator c)
        {
            int parent = (current - 1) / 2;
            while (current != 0)
            {
                if(c.compare(e[current], e[parent]) > 0)
                    mySwap(e, current, parent);
                else
                    break;
                current = parent;
                parent = (current - 1) / 2;
            }
        }
        
        public static <E> void mySwap(E e[], int index1, int index2)
        {
            E temp = e[index1];
            e[index1] = e[index2];
            e[index2] = temp;
        }
        
        public static <E> void heapSink(E e[], int parent, Comparator c, int size)
        {
            int leftChild = (2 * parent) + 1;
            int rightChild = leftChild + 1;
            if(rightChild < size) //has both left and right child
            {
                if(c.compare(e[leftChild], e[parent]) > 0)
                {
                    if(c.compare(e[rightChild], e[parent]) > 0)
                    {
                        if(c.compare(e[leftChild], e[rightChild]) > 0)
                        {
                            mySwap(e, parent, leftChild);
                            heapSink(e, leftChild, c, size);
                        }
                        else
                        {
                            mySwap(e, parent, rightChild);
                            heapSink(e, rightChild, c, size);
                        }
                    }
                    else
                    {
                        mySwap(e, parent, leftChild);
                        heapSink(e, leftChild, c, size);
                    }
                }
                else if(c.compare(e[rightChild], e[parent])> 0)
                {
                    mySwap(e, parent, rightChild);
                    heapSink(e, rightChild, c, size);
                }
                else
                    return;
            }
            else if(leftChild < size)//has only left child
            {
                if(c.compare(e[leftChild], e[parent]) > 0)
                {
                    mySwap(e, parent, leftChild);
                    heapSink(e, leftChild, c, size);
                }
                else
                    return;

            }
            else return; //no child
    }
        
        static class MyNode
        {
            int start;
            int end;
        }
        
        static class MyEdge
        {
            int from;
            int to;
            int weight;
            
            MyEdge(int f, int t, int w)
            {
                from = f;
                to = t;
                weight = w;
            }
            
            public String toString()
            {
                return from + " " + to + " " + weight;
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
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
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
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
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
