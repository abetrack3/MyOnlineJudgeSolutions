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
import java.util.HashSet;
 
public class CodeForces1335C
{
    
    public static Reader sc = new Reader();
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        int q = sc.nextInt();
        while (q-->0)
            System.out.println(solve3());
    }
    
    public static int solve() throws Exception
    {
        HashSet <Integer> unique = new HashSet<Integer>();
        int size = sc.nextInt();
        int arr[] = new int[size+1];
        int t = size;
        while (t-->0)
        {
            int k = sc.nextInt();
            if(unique.contains(k)) arr[k]++;
            else unique.add(k);
        }
        if(size == 1) return 0;
        if(size == 2) return 1;
        if(size == unique.size()) return 1;
        Integer arr2[] = new Integer[unique.size()];
        unique.toArray(arr2);
        int max = arr[arr2[0]];
        if(size - 1 >= max + 1) max++;
        if(max >= unique.size()) return unique.size();
        for(int i = 1; i < arr2.length; i++)
        {
            max = (arr[arr2[i]] > max) ? arr[arr2[i]] : max;
            if(size - 1 >= max + 1) max++;
            if(max >= unique.size()) return unique.size();
        }
        return max;
    }
    
    public static int solve2()throws Exception
    {
        HashSet <Integer> unique = new HashSet<Integer>();
        int size = sc.nextInt();
        int arr[] = new int[size+1];
        int t = size;
        while (t-->0)
        {
            int k = sc.nextInt();
            arr[k]++;
            unique.add(k);
        }
        if(size == 1) return 0;
        if(size == 2) return 1;
        if(size == unique.size()) return 1;
        Integer arr2[] = new Integer[unique.size()];
        unique.toArray(arr2);
        int max = 0;
        for(int i = 0; i < arr2.length; i++)
        {
            int frequency = arr[arr2[i]];
            if(frequency < unique.size() - 1)
            {
                max = (frequency > max) ? frequency : max;
                continue;
            }
            if(frequency == unique.size() - 1) return frequency - 1;
            if(frequency > unique.size()) return unique.size();
        }
        return max;
    }
    
    public static int solve3() throws Exception
    {
        HashSet <Integer> unique = new HashSet<Integer>();
        int size = sc.nextInt();
        int arr[] = new int[size+1];
        int t = size;
        while (t-->0)
        {
            int k = sc.nextInt();
            if(unique.contains(k)) arr[k]++;
            else unique.add(k);
        }
        if(size == 1) return 0;
        if(size == 2) return 1;
        if(size == unique.size()) return 1;
        Integer arr2[] = new Integer[unique.size()];
        unique.toArray(arr2);
        int max = 0;
        for(int i = 0; i < arr2.length; i++)
        {
            int diff = unique.size() - arr[arr2[i]];
            
            if(diff > 2)
            {
                int temp = arr[arr2[i]];
                if(unique.size() - 1 >= temp + 1) temp++;
                max = (max > temp) ? max : temp;
                
                continue;
            }
            if(diff == 1 || diff == 2)
            {
                max = (max > unique.size() - 1) ? max : unique.size() - 1;
                continue;
            }
            if(diff <= 0) return unique.size();
        }
        
        
        return max;
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
