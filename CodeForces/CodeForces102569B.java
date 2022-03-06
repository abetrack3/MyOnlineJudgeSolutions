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
import java.util.ArrayList;

public class CodeForces102569B
{
    
    public static int limit;
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        ArrayList <Integer> left = new ArrayList<Integer>();
        ArrayList <Integer> right = new ArrayList<Integer>();
        Reader sc = new Reader();
        int x, t = sc.nextInt(); limit = sc.nextInt();
        while (t --> 0)
        {
            x = sc.nextInt();
            if(x < 0) left.add(-x);
            else right.add(x);
        }
        java.util.Collections.sort(left);
        System.out.println(Math.max(solve(left, right), solve(right, left)));
    }
    
    public static int solve(ArrayList<Integer> left, ArrayList<Integer> right)
    {
        int i, j = i = -1;
        while (j < right.size() - 1)
        {
            if(right.get(j + 1) <= limit) j++;
            else break;
        }
        int ans = j + 1;
        while (i < left.size() - 1)
        {
            int leftCost = 2 * left.get(i + 1);
            if(leftCost > limit) break;
            int rightCost = limit - leftCost;
            while (j >= 0)
            {
                if(right.get(j) > rightCost) j--;
                else break;
            }
            ans = Math.max(ans, i + j + 3);
            i++;
        }
        return ans;
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
