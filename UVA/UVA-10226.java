// Working program using Reader Class 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main
{
    public static Node root=null;
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
            } while ((c = read()) >= '0' && c <= '9'); 
            
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
    
    public static void main(String[] args) throws IOException 
    { 
        Reader puttingvaluesinside=new Reader();
//        Node root=null;
        int t=puttingvaluesinside.nextInt(), total=0;
        puttingvaluesinside.readLine();
        while(t>0)
        {
            String s=puttingvaluesinside.readLine();
            if(s.equals(""))
            {
                printTree(root, total);
                t--;
                root=null;
                total=0;
                if(t>0)
                    System.out.println();
                continue;
            }
            total++;
            add(root, s);
        }
    }
    
    public static void printTree(Node h, int total)
    {
        if(h==null)
            return;
        printTree(h.left, total);
        h.nodePrint(total);
        printTree(h.right, total);
    }
    
    public static void add(Node h, String s)
    {
        if(root==null)
        {
            root=new Node(s);
            return;
        }
        if(s.equals(h.type))
            h.count++;
        else if(s.compareTo(h.type)<0)
        {
            if(h.left==null)
                h.left=new Node(s);
            else
                add(h.left, s);
        }
        else if(s.compareTo(h.type)>0)
        {
            if(h.right==null)
                h.right=new Node(s);
            else
                add(h.right, s);
        }
    }
}

class Node
{
    Node left, right;
    String type;
    int count;
    
    Node(String s)
    {
        type=s;
        left=right=null;
        count=1;
    }
    
    public void nodePrint(int total)
    {
        System.out.printf("%s %.4f\n",type, (100.00*count)/total);
    }
}