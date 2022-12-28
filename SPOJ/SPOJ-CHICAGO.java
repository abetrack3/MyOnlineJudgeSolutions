import java.io.DataInputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Reader sc = new Reader();
        int nodeCount = sc.nextInt();
        while (nodeCount != 0)
        {
            int edgeCount = sc.nextInt();
            int g[][] = new int[nodeCount][nodeCount];
            for(int x[] : g) java.util.Arrays.fill(x, -1);
            while (edgeCount --> 0)
            {
                int from = sc.nextInt() - 1, to = sc.nextInt() - 1;
                int weight = sc.nextInt();
                g[from][to] = g[to][from] = weight;
            }
            dijkstra(g);
            nodeCount = sc.nextInt();
        }
    }
    
    public static void dijkstra(int g[][])
    {
        double key[] = new double[g.length];
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Integer.MIN_VALUE);
        key[0] = 1.0;
        keySet[0] = true;
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return (key[a] == key[b]) ? 0 : (key[a] > key[b]) ? -1 : 1;
                }});
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            keySet[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(g[current][i] == -1) continue;
                if(!keySet[i] & (g[current][i]/100.0 * key[current]) > key[i])
                {
                    queue.remove(i);
                    key[i] = g[current][i]/100.0 * key[current];
                    queue.add(i);
                }
            }
        }
        System.out.printf("%.6f percent\n", 100.0*key[key.length - 1]);
    }
    
    static class Reader
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
        public Reader(){ 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        }
        public int nextInt() throws Exception{ 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
            if (neg) return -ret; 
            return ret; 
        }
        private void fillBuffer() throws Exception { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) buffer[0] = -1; 
        }
        private byte read() throws Exception { 
            if (bufferPointer == bytesRead) fillBuffer(); 
            return buffer[bufferPointer++]; 
        }
        public void close() throws Exception { 
            if (din == null) return; 
            din.close(); 
        } 
    }
    
}