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
import java.util.BitSet;
 
public class CodeForces1352E
{
    
    public static BitSet b = new BitSet(100000000);
    public static int arr[] = new int[8000];
    
    public static void main(String[] args) throws Exception
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while (test --> 0)
        {
            b.clear();
            int size = sc.nextInt();
            arr[0] = sc.nextInt();
            for(int i = 1; i < size; i++)
            {
                arr[i] = sc.nextInt() + arr[i-1];
                for(int j = 0; j < i; j++) b.set(getSum(j, i));
            }
            int count = 0;
            for(int i = 0; i < size; i++) if(b.get(getSum(i, i))) count++;
            System.out.println(count);
        }
    }
    
    public static int getSum(int i, int j)
    {
        if(i == 0) return arr[j];
        else return arr[j] - arr[i-1];
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
