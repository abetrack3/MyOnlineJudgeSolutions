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
    public static int size = 10001;
    public static HashMap <Integer, Integer> pf[] = new HashMap[size];
    
    public static void main(String[] args) throws Exception
    {
        build();
        Reader puttingvaluesinside = new Reader();
        StringBuilder sb = new StringBuilder();
        int t = puttingvaluesinside.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int m = puttingvaluesinside.nextInt();
            int n = puttingvaluesinside.nextInt();
            int ans = solve(m, n);
            sb.append("Case "+i+":");
            sb.append(System.getProperty("line.separator"));
            sb.append((ans == -1)?"Impossible to divide":ans);
            sb.append(System.getProperty("line.separator"));
        }
        System.out.print(sb);
    }
    
    public static void build()
    {
        pf[0] = new HashMap<Integer, Integer>();
        pf[1] = new HashMap<Integer, Integer>();
        pf[2] = new HashMap<Integer, Integer>();
        pf[2].put(2, 1);
        for(int i = 3; i < pf.length; i++)
            primeFactorization(i);
    }
    
    public static void primeFactorization(int i)
    {
        pf[i] = new HashMap<Integer, Integer>();
        //divides by two
        int t = i;
        if (i % 2 == 0)
        {
            pf[i].put(2, 1);
            i /= 2;
            while (i % 2 == 0)
            {
                pf[t].put(2, 1+pf[t].get(2));
                i /= 2;
            }
        }
        for(int j = 3; j*j <= i; j += 2)
        {
            if (i % j == 0)
            {
                pf[t].put(j, 1);
                i /= j;
                while (i % j == 0)
                {
                    pf[t].put(j, 1+pf[t].get(j));
                    i /= j;
                }
            }
        }
        if (i > 2)
            pf[t].put(i, 1);
    }
    
    public static int solve(int a, int b)
    {
        Integer primes[] = new Integer[pf[a].size()];
        pf[a].keySet().toArray(primes);
        Integer power[] = new Integer[pf[a].size()];
        pf[a].values().toArray(power);
        int sum = 0;
        for(int i = 2; i <= b; i++)
        {
            if(pf[i].containsKey(primes[0]))
                sum += pf[i].get(primes[0]);
        }
        int max = 0;
        if(sum < power[0])
            return -1;
        else max = sum / power[0];
        for (int j = 1; j < primes.length; j++)
        {
            sum = 0;
            for(int i = 2; i <= b; i++)
            {
                if(pf[i].containsKey(primes[j]))
                    sum += pf[i].get(primes[j]);
            }
            int temp = 0;
            if(sum < power[j])
                return -1;
            else
            {
                temp = sum / power[j];
                max = (max > temp) ? temp : max;
            }
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
