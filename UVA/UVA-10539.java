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
import java.util.BitSet;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class Main
{
    
    public static BitSet sieve = new BitSet(1000000);
    public static ArrayList <Long> arr = new ArrayList<Long>();
    public static final long limit = (long)Math.pow(10, 12);
    
    public static void main(String[] args) throws Exception
    {
        build();
        solve();
//        test();
    }
    
    public static void solve() throws Exception
    {
        Reader sc = new Reader();
        long n = sc.nextLong();
        while (n --> 0)
        {
            long low = sc.nextLong();
            long high = sc.nextLong();
            long lowIndex = java.util.Collections.binarySearch(arr, low);
            lowIndex = (lowIndex < 0) ? -(lowIndex + 1) : lowIndex;
//            System.out.println("lowIndex = " + lowIndex);
            long highIndex = java.util.Collections.binarySearch(arr, high);
            highIndex = (highIndex < 0) ? -(highIndex + 1) : highIndex;
//            System.out.println("highIndex = " + highIndex);
            System.out.println(highIndex - lowIndex);
//            System.out.println(linearSearch(low, high));
        }
    }
    
    public static void build() throws Exception
    {
        createBitSetSieve();
//        System.out.println("sieve = " + sieve);
        for(int i = sieve.nextSetBit(0); i != -1; i = sieve.nextSetBit(i + 1))
        {
            long a = i; a *= a;
            while (a <= limit & a > 0)
            {
                arr.add(a);
                a *= (long)i;
            }
        }
        java.util.Collections.sort(arr);
//        System.out.println("arr.size() = " + arr.size());
//        System.out.println("arr = " + arr);
//        FileWriter out = new FileWriter(new File("AlmostPrimeNumbers.txt"));
//        for(long x : arr)
//            out.write(x+"\n");
//        out.flush();
    }
    
    public static void createBitSetSieve()
    {
        sieve.set(0);
        sieve.set(1);
        for(int i = 4; i < sieve.size(); i += 2)
            sieve.set(i);
        for(int i = 3; i * i< sieve.size(); i += 2)
        {
            if(sieve.get(i)) continue;
            for(int j = i * i; j < sieve.size(); j += 2 * i)
                sieve.set(j);
        }
        sieve.flip(0, sieve.size());
    }
    
    public static void test()
    {
        int n = 1;
        while (true)
        {
            long low = (long)(Math.random()*Math.pow(10, 12));
            long high = (long)(Math.pow(10, 12)*Math.random());
            if(low > high)
            {
                long temp = high;
                high = low;
                low = temp;
            }
            long ans1 = linearSearch(low, high);
            long lowIndex = java.util.Collections.binarySearch(arr, low);
            lowIndex = (lowIndex < 0) ? -(lowIndex + 1) : lowIndex;
            long highIndex = java.util.Collections.binarySearch(arr, high);
            highIndex = (highIndex < 0) ? -(highIndex + 1) : highIndex;
            long ans2 = highIndex - lowIndex;
            if(ans1 != ans2)
            {
                System.out.println("Error found");
                System.out.println("low = " + low);
                System.out.println("high = " + high);
                System.out.println("ans1 = " + ans1);
                System.out.println("ans2 = " + ans2);
                break;
            } else System.out.println("Successful Test "+n++);
        }
    }
    
    public static long linearSearch(long low, long high)
    {
        int i = 0;
        for(long x : arr)
            if(x >= low & x <= high) i++;
        return i;
    }
    
    static class Reader
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
        public Reader(){ 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        }
        public long nextLong() throws IOException { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) return -ret; 
            return ret; 
        }
        private void fillBuffer() throws IOException { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) buffer[0] = -1; 
        }
        private byte read() throws IOException { 
            if (bufferPointer == bytesRead) fillBuffer(); 
            return buffer[bufferPointer++]; 
        }
        public void close() throws IOException { 
            if (din == null) return; 
            din.close(); 
        } 
    }
    
}
