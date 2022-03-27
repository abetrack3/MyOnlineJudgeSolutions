import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class CodeForces1167C {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        int n = scanner.nextInt();
        DisjointSet ds = new DisjointSet(n);
        for (int i = scanner.nextInt(); i --> 0;) {
            int k = scanner.nextInt();
            if (k > 0) {
                int a = scanner.nextInt();
                for (int j = k - 1; j --> 0;) {
                    int b = scanner.nextInt();
                    ds.union(a, b);
                    a = b;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("" + ds.weight[ds.findRoot(1)]);
        IntStream.rangeClosed(2, n).forEach((int i) -> {
            int root = ds.findRoot(i);
            int weight = ds.weight[root];
            sb.append(" " + weight);
        });
        sb.append("\n");
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        writer.write(sb.toString());
        writer.flush();
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

        public int findRoot(int n) {
            return n == root[n] ? n : (root[n] = findRoot(root[n]));
        }

        public void union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);
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
