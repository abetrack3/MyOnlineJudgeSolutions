import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class HackerEarth_minimum_xor {
    public static void main(String... args) throws IOException{
        run();
        // bruteForceTest();
    }

    public static void run() throws IOException{
        Reader scanner = new Reader();
        Trie tr = new Trie();
        StringBuilder sb = new StringBuilder();
        for (int q = scanner.nextInt(); q --> 0;) {
            switch (scanner.nextInt()) {
                case 1: {
                    tr.insert(scanner.nextLong());
                    break;
                } case 2: {
                    long xor = scanner.nextLong();
                    long ith = scanner.nextLong();
                    sb.append(tr.find(xor, ith) + "\n");
                    break;
                }
            }
        }
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        writer.write(sb.toString());
        writer.flush();
    }

    public static void bruteForceTest() {
        int test = 1;
        int queryRange = 100;
        long numXORRange = (long) 1e18;
        while (true) {
            ArrayList<Long> list = new ArrayList<Long>();
            Trie tr = new Trie();
            int query = 1 + (int)(Math.random() * queryRange);
            StringBuilder sb = new StringBuilder();
            sb.append(query + "\n");
            while (query --> 0) {
                long num = 1 + (long)(Math.random() * numXORRange);
                long xor = 1 + (long)(Math.random() * numXORRange);
                list.add(num);
                tr.insert(num);
                sb.append("1 " + num + "\n");
                for (int i = list.size(); i --> 0;) {
                    sb.append("2 " + xor + " " + (i+1) + "\n");
                    long res1 = tr.find(xor, i + 1);
                    ArrayList<Long> temp = new ArrayList<Long>();
                    list.forEach((x) -> temp.add(x ^ xor));
                    Collections.sort(temp);
                    long res2 = temp.get(i);
                    if (res1 != res2) {
                        System.out.println("Error " + test);
                        System.out.println(sb.toString());
                        return;
                    }
                }
            }
            System.out.println("Test Passed " + test);
            test++;
        }
    }

    static class Trie {

        Node root = new Node();

        public long find(long xor, long ith) {
            Node current = root;
            long left = 1;
            long ans = 0;
            for (int i = 63; i --> 0;) {
                if (current.zero == null) {
                    ans |= 1L << i;
                    current = current.one;
                    continue;
                } else if (current.one == null) {
                    current = current.zero;
                    continue;
                }
                long bit = (xor >> i) & 1L;
                if (bit == 0) {
                    if (left <= ith && ith <= left + current.zero.size - 1) {
                        current = current.zero;
                    } else {
                        ans |= 1L << i;
                        left = left + current.zero.size;
                        current = current.one;
                    }
                } else {
                    if (left <= ith && ith <= left + current.one.size - 1) {
                        ans |= 1L << i;
                        current = current.one;
                    } else {
                        left = left + current.one.size;
                        current = current.zero;
                    }
                }
            }
            return ans ^ xor;
        }

        public int size() {
            return (root.zero == null ? 0 : root.zero.size) + (root.one == null ? 0 : root.one.size);
        }

        public void insert(long val) {
            Node current = root;
            for (int i = 63; i --> 0;) {
                long bit = (val >> i) & 1L;
                if (bit == 0) {
                    current = current.zero == null ? (current.zero = new Node()) : current.zero;
                } else {
                    current = current.one == null ? (current.one = new Node()) : current.one;
                }
                current.size++;
            }
        }

        static class Node {
            Node one;
            Node zero;
            int size;
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
