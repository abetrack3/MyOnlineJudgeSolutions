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
import java.lang.StringBuilder;

public class Main
{
    
    public static HashMap <Long, Long> cache = new HashMap<Long, Long>();
    public static StringBuilder s = new StringBuilder();
    
    public static void main(String[] args) throws Exception
    {
        cache.put((long)1, (long)1);
        Reader puttingvaluesinside = new Reader();
        int t = puttingvaluesinside.nextInt();
        long runtime = 0;
        while(t-->0)
        {
            int left = puttingvaluesinside.nextInt();
            int right = puttingvaluesinside.nextInt();
            long runTime = System.nanoTime();
            solve(left, right);
            runtime += System.nanoTime() - runTime;
        }
        System.out.print(s);
//        System.out.println("runtime = " + runtime/1000000);
    }
    
    public static void solve(int left, int right)
    {
        HashMap <Long, Long> map = new HashMap<Long, Long>();
        long maxDiv = 0;
        if(cache.containsKey((long)left))
            maxDiv = cache.get((long)left);
        else
        {
            findFactor(left, map);
            maxDiv = countDivisor(map);
        }
        long max = left;
        for(long i = left + 1; i <= right; i++)
        {
//            System.out.println("i = " + i);
            long temp = 0;
            if(cache.containsKey(i))
                temp = cache.get(i);
            else
            {
                map = new HashMap<Long, Long>();
                findFactor(i, map);
                temp = countDivisor(map);
                cache.put((long)i, temp);
            }
            if(temp > maxDiv)
            {
                maxDiv = temp;
                max = i;
            }
        }
//        System.out.println("Between "+left+" and "+right+", "+max+" has a maximum of "+maxDiv+" divisors.");
        s.append("Between "+left+" and "+right+", "+max+" has a maximum of "+maxDiv+" divisors.");
        s.append(System.getProperty("line.separator"));
    }
    
    public static void findFactor(long t, HashMap <Long, Long> list)
    {
        //divides by two
        while(t%2==0)
        {
//            list.add((long)(2));
            long m = 2;
            long n = 1;
            if(list.containsKey(m))
                list.put(m, list.get(m)+1);
            else
                list.put(m, n);
            t/=2;
        }
        //check for all possible odd prime number divisor
        for(long i = 3; i*i <= t; i += 2)
        {
            if(t%i==0)
            {
//                list.add((long)i);
                if(list.containsKey(i))
                list.put((long)i, list.get(i)+1);
            else
                list.put((long)i, (long)1);
                t /= i;
                i -= 2;
            }
        }
        //if t at the end is a prime number
        if(t > 2)
        {
//            list.add(t);
            if(list.containsKey(t))
                list.put((long)t, list.get(t)+1);
            else
                list.put((long)t, (long)1);
        }
        if(list.size() == 0)
        {
//            list.add(t);
            list.put(t, (long)1);
        }
    }
    
    public static long countDivisor(HashMap <Long, Long> list)
    {
        long count = 1;
        Long prime[] = new Long[list.size()];
        Long frequency[] = new Long[list.size()];
        list.keySet().toArray(prime);
        list.values().toArray(frequency);
        for(int i = 0; i < frequency.length; i++)
        {
//            count *= (prime[i] == 1) ? 1 : frequency[i] + 1;
            count *= frequency[i] + 1;
        }
        
        return count;
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
