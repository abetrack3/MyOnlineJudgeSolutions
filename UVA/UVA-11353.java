
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.lang.StringBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */
public class Main
{
    
    public static Element arr[];
    public static Element arrSorted[];
    public static int divisorcount[];
    
    public static void main(String[] args) throws Exception
    {
        build();
        StringBuilder out = new StringBuilder();
        Reader puttingvaluesinside = new Reader();
        int n = puttingvaluesinside.nextInt();
        int i = 1;
        while (n != 0)
        {
            out.append("Case "+i+": "+arrSorted[n].value);
            out.append(System.getProperty("line.separator"));
            i++;
            n = puttingvaluesinside.nextInt();
        }
        System.out.print(out);
    }
    
    public static void build()
    {
        int sieve[] = new int[2000001];
        createRainbowSieve(sieve);
        arr = new Element[2000001];
        arr[0] = new Element(0, 1);
        arr[1] = new Element(1, 1);
        for(int i = 2; i < arr.length;i++)
            arr[i] = new Element(i, primeDivisorCountRainbowSieve(i, sieve));
        arrSorted = mergeSort(arr);
    }
    
    public static Element[] //changes
        mergeSort(Element [] arr) //changes
    {
        if(arr.length==1)
            return arr;
        if(arr.length==2)
        {
//            if(arr[1]<arr[0])
            if(compare(arr[1], arr[0]) == -1)
            {
                Element temp=arr[0]; //changes
                arr[0]=arr[1];
                arr[1]=temp;
            }
            return arr;
        }
        int left=arr.length/2;
        Element arrL[]=new Element[left]; //changes
        for(int i=0;i<left;i++)
            arrL[i]=arr[i];
        Element arrR[]=new Element[arr.length-left]; //changes
        for(int i=left;i<arr.length;i++)
            arrR[i-left]=arr[i];
        return mergeArray(mergeSort(arrL), mergeSort(arrR));
    }
    
    private static Element[] //changes
        mergeArray(Element []arr1, Element []arr2) //changes
    {
        int a=0, b=0;
        Element arr[]=new Element[arr1.length+arr2.length]; //changes
        for(int i=0;i<arr.length;i++)
        {
            if(a<arr1.length&&b<arr2.length)
            {
//                if(arr1[a]<arr2[b])
                if(compare(arr1[a], arr2[b]) == -1)
                {
                    arr[i]=arr1[a];
                    a++;
                }
                else
                {
                    arr[i]=arr2[b];
                    b++;
                }
            }
            else if(a<arr1.length)
            {
                arr[i]=arr1[a];
                a++;
            }
            else if(b<arr2.length)
            {
                arr[i]=arr2[b];
                b++;
            }
        }
        return arr;
    }
    
    private static int compare(Element a, Element b)
    {
        /*
        if a < b return -1
        if a == b return 0
        if a > b return 1
        */
        if(a.primeCount < b.primeCount) return -1;
        else if(a.primeCount > b.primeCount) return +1;
        else if(a.primeCount == b.primeCount)
        {
            if(a.value < b.value) return -1;
            else if(a.value > b.value) return +1;
            else return 0;
        }
        return 0;
    }
    
    public static void createRainbowSieve(int [] arr)
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
    }
    
    public static int primeDivisorCountRainbowSieve(int x, int rainbowSieve[])
    {
        int pot = x;
        int count = 0;
        while(x!=1)
        {
            x/=(rainbowSieve[x]==0)?x:rainbowSieve[x];
            count++;
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

class Element
{
    int value;
    int primeCount;
    
    Element(int v, int p)
    {
        value = v;
        primeCount = p;
    }
    
    public String toString()
    {
        String s = "";
        s = "["+value+", "+primeCount+"]";
        return s;
    }
    
}
