import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CodeForces771A {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[] edgeCount = new int[n + 1];
        DisjointSet ds = new DisjointSet(n);
        
        for (int i = m; i --> 0;) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ds.union(a, b);
            edgeCount[Math.min(a,b)]++;
        }
        
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        IntStream.rangeClosed(1, n).forEach((int i) -> {
            int root = ds.getRoot(i);
            map.put(root, map.getOrDefault(root, 0L) + edgeCount[i]);
        });

        AtomicBoolean flag = new AtomicBoolean(true);
        Arrays.stream(ds.root).distinct().forEach((int root) -> {
            if (root == 0 && flag.get()) {
                return;
            }
            int weight = ds.weight[root];
            long maxEdges = weight;
            maxEdges *= maxEdges - 1;
            maxEdges /= 2;

            // long ans = LongStream.rangeClosed(1, n)
            //             .filter((long i) -> root == ds.getRoot((int)i))
            //             .map((long i) -> edgeCount[(int)i])
            //             .sum();
            long ans = map.get(root);
            if (ans != maxEdges) {
                flag.set(false);
            }

        });
        System.out.println(flag.get() ? "YES" : "NO");
    }

    static class DisjointSet {
        int[] root;
        int[] weight;

        DisjointSet(int n) {
            root = new int[n + 1];
            weight = new int[n + 1];
            IntStream.rangeClosed(0, n).parallel().forEach((int i) -> {
                root[i] = i;
                weight[i] = 1;
            });
        }

        public int getRoot(int v) {
            return v == root[v] ? v : (root[v] = getRoot(root[v]));
        }

        public void union(int a, int b) {
            a = getRoot(a);
            b = getRoot(b);
            if (a == b) return;
            if (weight[a] < weight[b]) {
                root[a] = b;
                weight[b] += weight[a];
            } else {
                root[b] = a;
                weight[a] += weight[b];
            }
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