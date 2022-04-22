import java.util.Scanner;

public class CodeForces1669F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            arr[0] = sc.nextInt();
            for (int i = 1; i < arr.length; i++) {
                arr[i] = sc.nextInt() + arr[i - 1];
            }
            int left = 0, right = arr.length - 1;
            int ans = 0;
            while (left < right) {
                int sumAlice = sum(arr, 0, left);
                int sumBob = sum(arr, right, n - 1);
                if (sumAlice == sumBob ) {
                    ans = (left + 1) + (n - right);
                    left++;
                    right--;
                } else if (sumAlice < sumBob) {
                    left++;
                } else  {
                    right--;
                }
            }
            System.out.println(ans);
        }
    }

    public static int sum(int[] arr, int from, int to) {
        return arr[to] - (from == 0 ? 0 : arr[from - 1]);
    }
}
