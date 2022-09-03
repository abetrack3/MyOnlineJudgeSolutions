import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.ArrayList;

public class Main
{
    
    public static int maxNode = -1;
    public static int maxSum = 0;
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader puttingvaluesinside = new Reader();
        int q = puttingvaluesinside.nextInt();
        for(int i = 1; i <= q; i++)
        {
            System.gc();
            maxNode = -1;
            maxSum = 0;
            int size = puttingvaluesinside.nextInt();
            MyGraph G = new MyGraph(size, 2 * (size - 1));
            boolean flag = false;
            for(int j = size--; size-->0;)
            {
                int from = puttingvaluesinside.nextInt();
                int to = puttingvaluesinside.nextInt();
                int weight = puttingvaluesinside.nextInt();
                if(from >= G.nodeCount || to >= G.nodeCount)
                {
                    flag = true;
                    continue;
                }
                G.addEdge(from, to, weight);
                G.addEdge(to, from, weight);
            }
            if(flag)
                System.out.println("Case "+i+": -1");
            else
            {
                solve(G);
                System.out.println("Case "+i+": "+maxSum);
            }
        }
    }
    
    public static void solve(MyGraph G)
    {
        bfs(G, 0);
        int temp = maxNode;
        maxNode = -1;
        maxSum = 0;
        bfs(G, temp);
    }
    
    public static void bfs(MyGraph G, int startingNode)
    {
        boolean visited[] = new boolean[G.nodeCount];
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> sum = new ArrayList<Integer>();
        visited[startingNode] = true;
        queue.add(startingNode);
        sum.add(0);
        while (queue.size() != 0)
        {
            int currentNode = queue.get(0);
            int start = G.nodes[currentNode].start;
            int end = G.nodes[currentNode].end;
            for(int i = start; i <= end; i++)
            {
                int to = G.edges[i].to;
                int weight = G.edges[i].weight;
                if(!visited[to])
                {
                    queue.add(to);
                    sum.add(sum.get(0) + weight);
                    visited[to] = true;
                    if(sum.get(sum.size() - 1) > maxSum)
                    {
                        maxNode = to;
                        maxSum = sum.get(sum.size() - 1);
                    }
                }
            }
            queue.remove(0);
            sum.remove(0);
        }
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