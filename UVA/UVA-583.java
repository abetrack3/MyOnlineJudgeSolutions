/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static int a;
    public static Reader puttingvaluesinside;
    public static StringBuilder output = new StringBuilder();
    
    public static void main(String[] args) throws Exception
    {
        puttingvaluesinside = new Reader();
        int rainbowSieve[] = new int[100001];
        int previousPrime[] = new int[100001];
        createRainbowSieve(rainbowSieve, previousPrime);
        while(input())
        {
            int b = a;
            if(b==-1)
            {
//                System.out.println("-1 = -1 x ");
                output.append("-1 = -1 x ");
                output.append(System.getProperty("line.separator"));
                continue;
            }
            PriorityQueue <Integer>pq = new PriorityQueue<Integer>();
            if(b<0)
            {
                pq.add(-1);
                b=-b;
            }
            if(b<rainbowSieve.length)
                primeDivisorCountRainbowSieve(b, rainbowSieve, pq);
            else
            {
                int c = (int)Math.sqrt(b);
                while(rainbowSieve[c]!=0)
                    c--;
                while(c!=0)
                {
                    if(b%c==0)
                    {
                        while(b%c==0)
                        {
                            
                            pq.add(c);
                            b/=c;
                        }
                    }
                    else
                        c = previousPrime[c];
                }
                if(b!=1)
                    pq.add(b);
            }
            Object elem[] = pq.toArray();
            Arrays.sort(elem);
//            System.out.print(a+" = ");
            output.append(a+" = ");
            if(elem.length>0)
            {
//                System.out.print(elem[0]);
                output.append(elem[0]);
            }
            for(int i=1;i<elem.length;i++)
            {
//                System.out.print(" x "+elem[i]);
                output.append(" x "+elem[i]);
            }
//            System.out.println();
            output.append(System.getProperty("line.separator"));
//            System.out.println(output);
        }
        System.out.print(output);
    }
    
    public static void createRainbowSieve(int [] arr, int [] arr2)
    {
        int previous = 2;
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=2;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                arr2[i] = previous;
                previous = i;
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=i;
            }
        }
        for(int i=previous+2;i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                arr2[i]=previous;
                previous=i;
            }
        }
    }
    
    public static int primeDivisorCountRainbowSieve(int x, int rainbowSieve[], PriorityQueue <Integer>pq)
    {
        int count = 0;
        while(x!=1)
        {
            pq.add((rainbowSieve[x]==0)?x:rainbowSieve[x]);
            x/=(rainbowSieve[x]==0)?x:rainbowSieve[x];
            count++;
        }
        
        return count;
    }
    
    public static boolean input() throws Exception
    {
        a = puttingvaluesinside.nextInt();
        return a!=0;
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
