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
import java.util.HashMap;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class Main
{
    
    public static int arr[];
    public static HashMap <Integer, Integer> map;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int test = sc.nextInt();
        while(test --> 0)
        {
            int size = sc.nextInt(), queries = sc.nextInt();
            map = new HashMap<Integer, Integer>();
            map.put(0, size);
            arr = new int[size];
            for(int i = 0; i < arr.length; i++)
                update(i, sc.nextInt());
            while (queries --> 0)
            {
                int type = sc.nextInt();
                if(type == 1)
                {
                    int pos = sc.nextInt() - 1;
                    int val = sc.nextInt();
                    update(pos, val);
                }
                else if(map.containsKey(0))
                    sb.append(map.size() - 1 + "\n");
//                    System.out.println(map.size() - 1);
                else
                    sb.append(map.size() + "\n");
//                    System.out.println(map.size());
            }
        }
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        out.write(sb.toString());
        out.flush();
    }
    
    public static void update(int pos, int val)
    {
        remove(pos);
        add(pos, val);
    }
    
    public static void remove(int pos)
    {
        int fr = map.get(arr[pos]);
        if(fr == 1)
            map.remove(arr[pos]);
        else
            map.put(arr[pos], fr - 1);
    }
    
    public static void add(int pos, int val)
    {
        arr[pos] = val;
        if(map.containsKey(arr[pos]))
            map.put(arr[pos], 1 + map.get(arr[pos]));
        else
            map.put(arr[pos], 1);
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
        public int nextInt() throws Exception{ 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
            if (neg) return -ret; 
            return ret; 
        }
        private void fillBuffer() throws Exception { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) buffer[0] = -1; 
        }
        private byte read() throws Exception { 
            if (bufferPointer == bytesRead) fillBuffer(); 
            return buffer[bufferPointer++]; 
        }
        public void close() throws Exception { 
            if (din == null) return; 
            din.close(); 
        } 
    }
    
}
