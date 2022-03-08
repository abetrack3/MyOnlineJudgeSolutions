import java.util.Scanner;
public class CodeForces1650B {
    public static void main(String[] args) {
        run();
        // autoTesting();   
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int a = scanner.nextInt();

            System.out.println(solve(l, r, a));

        }
    }

    public static long solve(long l, long r, long a) {
        if (r == 1) {
            return 1;
        } else if (a == 1) {
            return r;
        } else if (r < a) {
            return r;
        } else if (l == r) {
            return l / a + l % a;
        } else {
            long highestMultiple = (r / a ) * a;
            long x = highestMultiple - 1;
            if (x < l)
                return r / a + r % a;
            else
                return Math.max(x / a + a - 1, r / a + r % a);
        }
    }

    public static long bruteForce(long l, long r, long a) {
        long max = -1;
        for (long i = l; i <= r; i++) {
            max = Math.max(i / a + i % a, max);
        }
        return max;
    }

    public static void autoTesting() {
        int max = 15;
        for (int l = 1; l <= max; l++) {
            for (int r = l; r < max; r++) {
                for (int a = 1; a < max; a++) {
                    long brute = bruteForce(l, r, a);
                    long solve = solve(l, r, a);
                    if(brute != solve) {
                        System.out.println("answer: " + brute);
                        System.out.println("wrong: " + solve);
                        System.out.println(l + " " + r + " " + a);
                        // return;
                    }
                }
            }
        }
        System.out.println("clear");
    }

}
