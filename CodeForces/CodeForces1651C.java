import java.util.Scanner;

public class CodeForces1651C {

    static int[] rowA;
    static int[] rowB;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            rowA = new int[n];
            rowB = new int[n];
            for (int i = 0; i < n; i++) { rowA[i] = scanner.nextInt(); }
            for (int i = 0; i < n; i++) { rowB[i] = scanner.nextInt(); }

            long ans = Integer.MAX_VALUE;

            // two connections
            ans = Math.min(ans, getCost(0, 0) + getCost(n - 1, n - 1)); //parallel
            ans = Math.min(ans, getCost(0, n - 1) + getCost(n - 1, 0)); //diagonal

            // four connections
            long topLeft = Integer.MAX_VALUE;
            long topRight = Integer.MAX_VALUE;
            long bottomLeft = Integer.MAX_VALUE;
            long bottomRight = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                topLeft = Math.min(topLeft, getCost(0, i));
                topRight = Math.min(topRight, getCost(n - 1, i));
                bottomLeft = Math.min(bottomLeft, getCost(i, 0));
                bottomRight = Math.min(bottomRight, getCost(i, n - 1));
            }
            ans = Math.min(ans, topLeft + topRight + bottomLeft + bottomRight);

            // three connections
            ans = Math.min(ans, getCost(0, 0) + topRight + bottomRight); // vertical left 
            ans = Math.min(ans, getCost(n - 1, n - 1) + topLeft + bottomLeft); // vertical right
            ans = Math.min(ans, getCost(0, n - 1) + topRight + bottomLeft); // topLeft and bottomRight connected
            ans = Math.min(ans, getCost(n - 1, 0) + topLeft + bottomRight); // topRight and bottomLeft connected

            System.out.println(ans);

        }
    }

    public static long getCost(int i, int j) {
        return Math.abs(rowA[i] - rowB[j]);
    }

}
