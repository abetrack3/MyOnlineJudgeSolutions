/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18101257
 */

import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class Main
{
    public static void main(String[] args) throws Exception
    {
        int arr[] = new int[1000001];
        createSieve(arr);
        int digitPrimes[] = new int[1000001];
        buildDigitPrimeConsecutiveSums(digitPrimes, arr);
//        for(int x:digitPrimes)
//            System.out.println("x = " + x);
//        System.out.println(checkSumPrime(2, arr));
//        System.out.println(checkSumPrime(3, arr));
//        System.out.println(checkSumPrime(5, arr));
//        System.out.println(checkSumPrime(7, arr));
//        System.out.println(checkSumPrime(17, arr));
//        System.out.println(checkSumPrime(11, arr));
//        System.out.println(checkSumPrime(13, arr));
//        System.out.println(checkSumPrime(19, arr));
        
//        checkSieve();

        Reader puttingvaluesinside = new Reader();
        int t = puttingvaluesinside.nextInt();
        while(t-->0)
        {
            int a = puttingvaluesinside.nextInt();
            int b = puttingvaluesinside.nextInt();
            if(a==0) System.out.println(digitPrimes[b]);
            else System.out.println(digitPrimes[b]-digitPrimes[a-1]);
        }
    }
    
    public static void createSieve(int [] arr)
    {
        arr[0]=arr[1]=1;
        for(int i=4;i<arr.length;i+=2)
            arr[i]=1;
        for(int i=3;i*i<arr.length;i+=2)
        {
            if(arr[i]==0)
            {
                for(int j=i*i;j<arr.length;j+=2*i)
                    arr[j]=1;
            }
        }
    }
    
    public static void checkSieve()
    {
        for(int i=10;i<=1000001;i*=10)
        {
            int arr[] = new int[i+1];
            createSieve(arr);
            int count = 0;
            for(int j=0;j<arr.length;j++)
                if(arr[j]==0) count++;
            System.out.println(i+" = " + count);
        }
    }
    
    public static void buildDigitPrimeConsecutiveSums(int arr[], int sieve[])
    {
        for(int i=2;i<arr.length;i++)
        {
            arr[i]=arr[i-1];
            if(sieve[i]==0)
            {
                if(checkSumPrime(i, sieve))
                    arr[i]++;
            }
        }
    }
    
    public static boolean checkSumPrime(int x, int sieve[])
    {
        char c[] = (""+x).toCharArray();
        int y = 0;
        for(char z:c)
            y+=z-'0';
        return sieve[y]==0;
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
