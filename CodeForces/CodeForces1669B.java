import java.util.Scanner;

public class CodeForces1669B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[sc.nextInt()]++;
            }
            int ans = -1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= 3) {
                    ans = i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
