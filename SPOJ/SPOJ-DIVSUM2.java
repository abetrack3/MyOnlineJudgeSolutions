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
//import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    
    public static ArrayList <Integer> sieve = new ArrayList<Integer>();
    
    public static void main(String[] args) throws Exception
    {
        createSieve(new int[100000001]);
        run();
    }
    
    public static void run() throws Exception
    {
        Reader puttingvaluesinside = new Reader();
        StringBuilder sb = new StringBuilder();
        int t = puttingvaluesinside.nextInt();
        while (t-->0)
        {
            long a = puttingvaluesinside.nextLong();
            sb.append(Long.toUnsignedString(solve(a))+"\n");
        }
        System.out.print(sb);
    }
    
    public static long solve(long t)
    {
        return sumOfDivisor(t) - t;
    }
    
    public static long sumOfDivisor(long t)
    {
        if(t == 0 || t == 1) return t;
        long sum = 1;
        long index = 1;
        while (t % 2 == 0)
        {
            t /= 2;
            index *= 2;
        }
        index *= 2;
        index--;
        sum *= index;
        index = 1;
        long prime = sieve.get((int)index);
        while (prime * prime <= t && index < sieve.size())
        {
            prime = sieve.get((int)index);
            if(t % prime == 0)
            {
                long count = 1;
                while (t % prime == 0)
                {
                    t /= prime;
                    count *= prime;
                }
                count *= prime;
                count--;
                count /= prime -1;
                sum *= count;
            }
            index++;
        }
        if(t > 2)
        {
            long count = t + 1;
            sum *= count;
        }
        return sum;
    }
    
    public static void createSieve(int [] arr)
    {
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=2;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=i;
            }
        }
        sieve.add(2);
        for(int i = 3; i < arr.length; i += 2)
            if(arr[i] == 0) sieve.add(i);
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
