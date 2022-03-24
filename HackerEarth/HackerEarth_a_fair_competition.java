import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

public class HackerEarth_a_fair_competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            DisjointSet ds = new DisjointSet(n);
            for (int m = scanner.nextInt(); m --> 0;) {
                ds.union(scanner.nextInt(), scanner.nextInt());
            }
            IntStream.rangeClosed(1, n).forEach(ds::getRoot);
            AtomicInteger count = new AtomicInteger();
            Arrays.stream(ds.root).distinct().forEach((int i) -> {
                if (i == 0) return;
                int weight = ds.weight[ds.getRoot(i)];
                ds.ans += weight * (n - weight);
                count.incrementAndGet();
            });
            System.out.println(count.get() == 1 ? 0 : ds.ans);
        }
    }

    static class DisjointSet {
        
        int[] root;
        int[] weight;
        long ans;

        DisjointSet(int n) {
            ans = 0;
            root = new int[n + 1];
            weight = new int[n + 1];
            IntStream
                .rangeClosed(0, n)
                .parallel()
                .forEach((int i) -> {
                    root[i] = i;
                    weight[i] = 1;
            });
        }

        public int getRoot(int x) {
            return x == root[x] ? x : (root[x] = getRoot(root[x]));
        }

        public void union(int a, int b) {
            a = getRoot(a);
            b = getRoot(b);
            if (a == b) {
                return;
            }
            if (weight[a] < weight[b]) {
                root[a] = b;
                weight[b] += weight[a];
            } else {
                root[b] = a;
                weight[a] += weight[b];
            }
        }

    }

}
