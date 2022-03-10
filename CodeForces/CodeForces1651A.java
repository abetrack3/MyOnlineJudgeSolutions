import java.util.Scanner;
public class CodeForces1651A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            int ans = (int)Math.pow(2, n) - 1;
            System.out.println(ans);
        }
    }
}

