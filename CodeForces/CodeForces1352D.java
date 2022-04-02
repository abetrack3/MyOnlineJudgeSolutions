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
import java.util.ArrayList;
 
public class CodeForces1352D
{
    
    public static ArrayList<Integer> arr;
    public static int moves, alice, prevAlice, bob, prevBob;
    
    public static void main(String[] args) throws Exception
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while (test --> 0)
        {
            moves = alice = prevAlice = bob = prevBob = 0;
            int size = sc.nextInt();
            arr = new ArrayList<Integer>();
            while(size --> 0) arr.add(sc.nextInt());
            game();
            System.out.println(moves+" "+alice+" "+bob);
        }
    }
    
    public static void game()
    {
        
        alice = prevAlice = arr.remove(0);
        moves++;
        
        while (!arr.isEmpty())
        {
            //bob
            int currentSum = 0;
            while(currentSum <= prevAlice & !arr.isEmpty())
                currentSum += arr.remove(arr.size() - 1);
            prevBob = currentSum;
            if(currentSum > 0) moves++;
            else break;
            bob += currentSum;
            
            
            //alice
            currentSum = 0;
            while (currentSum <= prevBob & !arr.isEmpty())
                currentSum += arr.remove(0);
            prevAlice = currentSum;
            if(currentSum > 0) moves++;
            else break;
            alice += currentSum;
            
        }
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
