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
import java.util.ArrayList;
import java.util.BitSet;
 
public class CodeForces1348B 
{
    public static void main(String[] args) throws Exception
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while (test --> 0)
        {
            StringBuilder sb = new StringBuilder();
            int c = sc.nextInt();
            int size = sc.nextInt();
            BitSet set1 = new BitSet();
            BitSet set2 = new BitSet();
            set2.set(1, c + 1);
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while (c --> 0)
            {
                int m = sc.nextInt();
                arr.add(m);
                set1.set(m);
                set2.clear(m);
            }
            if(set1.cardinality() > size) 
            {
                System.out.println("-1");
                continue;
            }
            for(int i = 0; i < size; i++)
            {
                int x = arr.get(i);
                if(set1.get(x)) {set1.clear(x);continue;}
                x = set1.nextSetBit(0);
                if(x != -1){arr.add(i, x);set1.clear(x);}
                else
                {
                    x = set2.nextSetBit(0);
                    arr.add(i, x);
                    set2.clear(x);
                }
            }
            int start = 1;
            int end = size;
            while (end < arr.size())
            {
                int ejected = arr.get(start - 1);
                int added = arr.get(end);
                if(ejected != added)
                    arr.add(end, ejected);
                start++;
                end++;
            }
            sb.append(arr.size()+"\n"+arr.get(0));
            for(int i = 1; i < arr.size(); i++)
                sb.append(" "+arr.get(i));
            System.out.println(sb);
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
