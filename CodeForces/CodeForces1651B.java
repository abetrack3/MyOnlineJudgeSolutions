import java.util.Scanner;
public class CodeForces1651B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[19];
        String[] ans = new String[19];
        ans[0] = "1";
        ans[1] = "1 3";
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = 3 * arr[i - 1];
            ans[i] = ans[i - 1] +" " + arr[i];
        }
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            if (n <= 19) {
                System.out.println("YES\n"+ans[n - 1]);
            } else System.out.println("NO");
        }
    }

    public static int next(int n) {
        int t = n;
        while (Math.abs(t - n) * 2 < t + n ) {
            t++;
        }
        return t;
    }

}
