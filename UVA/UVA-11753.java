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
import java.util.HashMap;

public class Main
{
    
    public static HashMap<Key, Integer> cache;
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Reader sc = new Reader();
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++)
        {
            int size = sc.nextInt();
            int limit = sc.nextInt();
            int arr[] = new int[size];
            boolean initiallyPalindrome = true;
            for(int j = 0, k = arr.length - 1; j < arr.length; j++, k--)
            {
                arr[j] = sc.nextInt();
                if(j >= arr.length / 2)
                    if(arr[j] != arr[k])
                        initiallyPalindrome = false;
            }
            if(initiallyPalindrome)
                System.out.println("Case "+i+": Too easy");
            else if(limit == 0)
                System.out.println("Case "+i+": Too difficult");
            else
            {
                int ans = solve(arr, limit);
                System.out.println("Case "+i+": "+((ans == -1)?"Too difficult":ans));
            }
        }
    }
    
    public static int solve(int arr[], int limit)
    {
        cache = new HashMap<Key, Integer>();
        int ans = traverse(0, arr.length - 1, arr, 0, limit);
        if(ans > limit) return -1;
        else return ans;
    }
    
    public static int traverse(int start, int end, int arr[], int count, int limit)
    {
        if(start == end || start > end)
            return count;
        if(count > limit)
            return count;
        if(arr[start] == arr[end])
            return traverse(start + 1, end - 1, arr, count, limit);
        else
        {
            Key key = new Key(start, end, count);
            if(cache.containsKey(key)) return cache.get(key);
            int a = traverse(start, end - 1, arr, count + 1, limit);
            int b = traverse(start + 1, end, arr, count + 1, limit);
            cache.put(key, Math.min(a, b));
            return Math.min(a, b);
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
class Key
{

    final int start;
    final int end;
    final int count;

    public Key(int x, int y, int z) {
        start = x;
        end = y;
        count = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return start == key.start && end == key.end && count == key.count;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 17 * result + end;
        result = 13 * result + count;
        return result;
    }

}
