import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            int testCases = sc.nextInt();

            while (testCases --> 0) {
                int n = sc.nextInt();
                solve(n);
            }

        }

    }


    public static void solve(long n) {

        long totalSum = n * (n + 1) / 2;
        int powerOf2 = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
        long geometricSum = (long)((Math.pow(2, powerOf2) - 1) * 2);
        long answer = totalSum - geometricSum;
        System.out.println(answer);

    }

}
