import java.util.Arrays;
import java.util.Scanner;
 
public class DisJointSetBruteTest {
 
    public static void main(String[] args) {
        run();
        // caseSpecificTest();
        // bruteForceTest();
    }
 
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DisjointSet ds1 = new DisjointSet(n);
        for (int i = scanner.nextInt(); i --> 0;) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ds1.union(a, b);
        }
        // Arrays.stream(ds1.root).forEach(ds1::getRoot);
        Arrays.setAll(ds1.root, (int j) -> ds1.root[j] = ds1.getRoot(j));
        long count1 = Arrays.stream(ds1.root).distinct().count() - 1;
        System.out.println(count1);
    }
 
    public static void caseSpecificTest() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DisjointSet ds1 = new DisjointSet(n);
        DisjointSet2 ds2 = new DisjointSet2(n);
        for (int i = scanner.nextInt(); i --> 0;) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.printf("%d %d%n", a, b);
            ds1.union(a, b);
            ds2.union(a, b);
            // Arrays.stream(ds1.root).forEach(ds1::getRoot);
            Arrays.setAll(ds1.root, (int j) -> ds1.root[j] = ds1.getRoot(j));
            Arrays.setAll(ds2.root, (int j) -> ds2.root[j] = ds2.getRoot(j));
            long count1 = Arrays.stream(ds1.root).distinct().count() - 1;
            long count2 = Arrays.stream(ds2.root).distinct().count() - 1;
            if (count1 != count2) {
                System.out.println("error");
                System.out.printf("%d %d%n", count1, count2);
                return;
            }
        }
    }
 
    public static void bruteForceTest() {
        int count = 1;
        while (true) {
            System.out.println("Test: " + count++);
            DisjointSet ds1 = new DisjointSet(10);
            DisjointSet2 ds2 = new DisjointSet2(10);
            for (int i = 5; i --> 0;) {
                int a = (int)(Math.random() * 10) + 1;
                int b;
                do {
                    b = (int)(Math.random() * 10) + 1;
                } while (a == b);
                System.out.printf("%d %d%n", a, b);
                ds1.union(a, b);
                ds2.union(a, b);
                // Arrays.stream(ds1.root).forEach(ds1::getRoot);
                Arrays.setAll(ds1.root, (int j) -> ds1.root[j] = ds1.getRoot(j));
                Arrays.setAll(ds2.root, (int j) -> ds2.root[j] = ds2.getRoot(j));
                long count1 = Arrays.stream(ds1.root).distinct().count();
                long count2 = Arrays.stream(ds2.root).distinct().count();
                if (count1 != count2) {
                    System.out.println("error");
                    System.out.printf("%d %d%n", count1, count2);
                    return;
                }
            }
 
        }
    }
    
    static class DisjointSet {
        int[] root;
        int[] weight;
 
        DisjointSet(int n) {
            root = new int[n + 1];
            weight = new int[n + 1];
            Arrays.parallelSetAll(root, (int i) -> root[i] = i);
            Arrays.parallelSetAll(weight, (int i) -> weight[i] = 1);
        }
 
        public String toString() {
            return Arrays.toString(root) + "\n" + Arrays.toString(weight);
        }
 
        public int getRoot(int i) {
            if (root[i] == i) {
                return i;
            }
            return root[i] = getRoot(root[i]);
        }
 
        public void union(int i, int j) {
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI == rootJ) return;
            if (weight[rootI] < weight[rootJ]) {
                root[rootI] = rootJ;
                weight[rootJ] += weight[rootI];
            } else {
                root[rootJ] = rootI;
                weight[rootI] += weight[rootJ];
            }
        }
    }
 
    static class DisjointSet2 {
        
        int[] root;
 
        DisjointSet2(int n) {
            root = new int[n + 1];
            Arrays.parallelSetAll(root, (int i) -> root[i] = i);
        }
 
        public int getRoot(int v) {
            if (v != root[v]) {
                return getRoot(root[v]);
            }
            return root[v];
        }
 
        public void union(int i, int j) {
            if ((i = getRoot(i)) != (j = getRoot(j))) {
                root[j] = i;
            }
        }
 
    }
 
}
