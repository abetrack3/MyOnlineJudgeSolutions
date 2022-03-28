import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class CodeForces500B {
    public static void main(String[] args) throws IOException {
        
        FastReader scanner = new FastReader();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        char[][] c = new char[n][];
        Arrays.setAll(arr, i -> arr[i] = scanner.nextInt());
        Arrays.setAll(c, i -> c[i] = scanner.nextLine().toCharArray());
        
        DisjointSet ds = new DisjointSet(n);
        for (int j = 0; j < n; j++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (c[j][j2] == '1') {
                    ds.union(arr[j], arr[j2]);
                }
            }
        }
        IntStream.rangeClosed(0, n).forEach(ds::findRoot);
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();
        Arrays.stream(arr).forEach(i -> {
            int root = ds.findRoot(i);
            if (!map.containsKey(root)) {
                map.put(root, new PriorityQueue<Integer>((x, y) -> x - y));
            }
            map.get(root).add(i);
        });
        
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(i -> {
            int root = ds.findRoot(i);
            sb.append(map.get(root).poll() + " ");
        });
        
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(sb.toString());
        pw.flush();
    }

    static class DisjointSet {
        
        int[] root;
        int[] weight;

        DisjointSet(int n) {
            root = new int[n + 1];
            weight = new int[n + 1];
            IntStream.rangeClosed(0, n).forEach(i-> {
                root[i] = i;
                weight[i] = 1;
            });
        }

        public boolean isSameRoot(int a, int b) {
            return findRoot(a) == findRoot(b);
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

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
