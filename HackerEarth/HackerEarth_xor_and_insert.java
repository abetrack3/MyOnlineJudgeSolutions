import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HackerEarth_xor_and_insert {
    public static void main(String[] args) throws IOException {
        
        Trie trie = new Trie();
        trie.insert(0);
        Reader scanner = new Reader();
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int t = scanner.nextInt(); t --> 0;) {
            int op  = scanner.nextInt();
            switch (op) {
                case 1: { trie.insert(scanner.nextInt());       break; } // insert
                case 2: { trie.applyXor(scanner.nextInt());     break; } // update
                case 3: { writer.write(trie.findMin() + "\n");  break; } // find minimum
            }
        }
        writer.flush();
    }

    static class Trie {

        int xor = 0;
        Node root = new Node();
        static String[] zeroes = new String[32];

        static {
            zeroes[0] = "";
            for (int i = 1; i < zeroes.length; i++) {
                zeroes[i] = zeroes[i - 1] + "0";
            }
        }
    
        static class Node {
    
            Node one;
            Node zero;
    
        }
    
        public void insert(int val) {
            val ^= xor;
            String s = Integer.toBinaryString(val);
            char[] c = zeroes[32 - s.length()].concat(s).toCharArray();
            Node current = root;
            for (char x : c) {
                if (x == '1') {
                    if (current.one == null) {
                        current.one = new Node();
                    }
                    current = current.one;
                } else {
                    if (current.zero == null) {
                        current.zero = new Node();
                    }
                    current = current.zero;
                }
            }
        }
    
        public void applyXor(int x) {
            xor ^= x;
        }
    
        public int findMin() {
            String s = Integer.toBinaryString(xor);
            char[] c = zeroes[32 - s.length()].concat(s).toCharArray();
            Node current = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                if (current.zero == null && current.one == null) {
                    break;
                }
                if (c[i] == '0') {
                    if (current.zero != null) {
                        sb.append('0');
                        current = current.zero;
                    } else {
                        sb.append('1');
                        current = current.one;
                    }
                } else {
                    if (current.one != null) {
                        sb.append('0');
                        current = current.one;
                    } else {
                        sb.append('1');
                        current = current.zero;
                    }
                }
            }
                
            return sb.length() == 0 ? 0 : Integer.parseInt(sb.toString(), 2);
        }
    
    }

    static class Reader {
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
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }

}