import java.util.Arrays;
import java.util.Scanner;

public class CodeForces1669C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0) {
            int n =sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = true;
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] % 2 != arr[i - 2] % 2) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
