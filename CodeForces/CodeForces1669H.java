import java.util.Scanner;

public class CodeForces1669H {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long test = sc.nextLong();
            while (test --> 0) {
                long n = sc.nextLong(), k = sc.nextLong();
                long[] bitCounter = new long[31];
                for (long i = 0; i < n; i++) {
                    long a = sc.nextLong();
                    for (int j = 0; j < bitCounter.length; j++) {
                        long bit = 1 & a;
                        a = a >> 1;
                        if (bit == 1) {
                            bitCounter[j]++;
                        }
                    }
                }
                long ans = 0;
                for (int i = 30; i >= 0; i--) {
                    if (bitCounter[i] == n) {
                        ans |= 1 << i;
                    } else if (bitCounter[i] < n && n - bitCounter[i] <= k) {
                        k -= n - bitCounter[i];
                        ans |= 1 << i;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
