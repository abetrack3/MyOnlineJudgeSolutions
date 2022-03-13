import java.io.*;
import java.util.*;

public class CodeForces1651D {

    static final int MAX = Integer.MAX_VALUE;
    static int[] adjRow = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] adjCol = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int adjCount = 4;
    public static void main(String[] args) throws IOException {
        
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        HashMap<Pair, Integer> set = new HashMap<>();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            set.put(arr[i], i);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(
            (Pair a, Pair b) -> { return a.getDistance() - b.getDistance(); }
        );

        // update and enQueue the pairs that are adjacent to excluded points
        for (Pair a : arr) {
            boolean found = false;
            for (int i = 0; i < adjCount; i++) {
                Pair t = new Pair(a.row + adjRow[i], a.col + adjCol[i]);
                if (!set.containsKey(t)) { //excluded point found
                    a.update(t);
                    found = true;
                }
            }
            if (found) {
                queue.add(a);
                a.added = true;
            }
        }

        while (!queue.isEmpty()) {
            Pair a = queue.poll();
            for (int i = 0; i < adjCount; i++) {
                Pair t = new Pair(a.row + adjRow[i], a.col + adjCol[i]);
                if (set.containsKey(t)) { // adjacent node found
                    t = arr[set.get(t)]; //getting original the adjacent node -- avoid duplicating adjacent node
                    t.update(a.nearest);
                    if (!t.added) {
                        queue.add(t);
                        t.added = true;
                    }
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Pair pair : arr) {
            writer.write(pair.nearest.toString() + "\n");
        }
        writer.flush();

    }

    static class Pair{

        static final int hashMultiplier = 1000000;

        int row;
        int col;
        Pair nearest;
        boolean added = false;
        
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
            nearest = null;
        }

        public void update(Pair b) {
            if (nearest == null) {
                nearest = b;
            } else if (this.getDistance() > Math.abs(this.row - b.row) + Math.abs(this.col - b.col)) {
                nearest = b;
            }
        }

        public int getDistance() {
            if (nearest == null) {
                return MAX;
            }
            return Math.abs(this.row - nearest.row) + Math.abs(this.col - nearest.col);
        }
        
        @Override
        public String toString() {
            return row + " " + col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
 
            Pair pair = (Pair) o;
 
            if (row != pair.row) return false;
            return col == pair.col;
        }
        
        @Override
        public int hashCode() {
            return hashMultiplier * row + col;
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
    }

}
