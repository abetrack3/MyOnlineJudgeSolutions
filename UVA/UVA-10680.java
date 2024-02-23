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
import java.util.Scanner;

public class Main
{
    
    public static int sieve[] = new int[1000001];
    
    public static void main(String[] args) throws Exception
    {
        createSieve(sieve);
//        Scanner puttingvaluesinside = new Scanner(System.in);
        Reader puttingvaluesinside = new Reader();
        StringBuilder out = new StringBuilder();
        int t = puttingvaluesinside.nextInt();
        while (t != 0)
        {
//            System.out.println(solve(t));
            out.append(solve(t)+"\n");
            t = puttingvaluesinside.nextInt();
        }
        System.out.print(out);
    }
    
    public static int solve(int a)
    {
        if(a == 1) return a;
        else if(a == 2) return 2;
        else if(a == 3) return 6;
        else if(a == 4) return 2;
        else if(a == 5) return 6;
        else if(a == 6) return 6;
        else if(a == 7) return 2;
        else if(a == 8) return 4;
        else if(a == 9) return 2;
        else if(a == 10) return 2;
//        int powerOf2 = (int)(Math.log10(a)/Math.log10(2));
        int powerOf2 = maxPower(2, a);
//        int powerOf3 = (int)(Math.log10(a)/Math.log10(3));
        int powerOf3 = maxPower(3, a);
//        int powerOf5 = (int)(Math.log10(a)/Math.log10(5));
        int powerOf5 = maxPower(5, a);
        powerOf2 -= powerOf5;
        int ans = ((int)(Math.pow(2, powerOf2)))%10;
        ans = multiplicationMod(ans, (int)(Math.pow(3, powerOf3)), 10);
        int i = 7;
        for(; i*i <= a; i += 2)
        {
            if(sieve[i] == 0)
            {
//                int powerOfI = (int)(Math.log10(a)/Math.log10(i));
                int powerOfI = maxPower(i, a);
                for(int j = 1; j <= powerOfI; j++)
                    ans = multiplicationMod(ans, i, 10);
            }
        }
        for(; i <= a; i += 2)
        {
            if(sieve[i] == 0)
                ans = multiplicationMod(ans, i, 10);
        }
        return ans;
    }
    
    public static int multiplicationMod(int a, int b, int mod)
    {
        return ((a%mod)*(b%mod))%mod;
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
    
    public static int maxPower(int base, int limit)
    {
        int count = 0;
        long temp = 1;
        while (temp * base <= limit)
        {
            count++;
            temp *= base;
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
