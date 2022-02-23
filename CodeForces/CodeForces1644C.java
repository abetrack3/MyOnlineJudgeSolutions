import java.util.Scanner;
public class CodeForces1644C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test --> 0) {
            int n = scanner.nextInt(), x = scanner.nextInt();
            int[] array = new int[n], ans = new int[n+1];
            array[0] = scanner.nextInt();
            for(int i = 1; i < n; i++) array[i] = scanner.nextInt() + array[i-1];

            for(int size = 1; size <= n; size++) {
                ans[size] = getSum(array, 0, size - 1);
                for(int i = 1, j = size; j < n; i++, j++) {
                    ans[size] = Math.max(ans[size], getSum(array, i, j));
                }
            }

            for(int i = ans.length - 2; i >= 0; i--) {
                ans[i] = (ans[i] > ans[i+1]) ? ans[i] : ans[i+1];
            }

            for(int i = 1; i < ans.length; i++) {
                ans[i] = Math.max(ans[i] + i * x, ans[i - 1]);
            }
            printArray(ans);
        }
    }

    public static int getSum(int[] array, int from, int to) {
        return array[to] - ((from == 0)? 0 : array[from-1]);
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("" + array[0]);
        for(int i = 1; i < array.length; i++)
            sb.append(" " + array[i]);
        System.out.println(sb.toString());
    }

}
