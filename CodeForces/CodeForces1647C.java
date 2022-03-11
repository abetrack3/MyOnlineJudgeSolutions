import java.util.Scanner;
public class CodeForces1647C {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        int test = reader.nextInt();
        while (test --> 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                char[] c = reader.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = c[j] - 48;
                }
                // System.out.println(java.util.Arrays.toString(arr[i]));
            }
            System.out.println(solve(arr, n, m));
        }
    }

    public static String solve(int[][] arr, int n, int m) {
        if (arr[0][0] == 1) {
            return "-1";
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    String s = getSubSection(i, j);
                    sb.append("\n" + s);
                    count++;
                }
            }
        }
        return count + sb.toString();
    }

    public static String getSubSection(int i, int j) {
        if (j == 0) {
            return String.format("%d %d %d %d", i, j+1, i+1, j+1);
        } else {
            return String.format("%d %d %d %d", i+1, j, i+1, j+1);
        }
    }
}