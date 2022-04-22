import java.util.Scanner;

public class CodeForces1669A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0) {
            int ratings = sc.nextInt();
            if (1900 <= ratings) {
                System.out.println("Division 1");
            } else if (1600 <= ratings) {
                System.out.println("Division 2");
            } else if (1400 <= ratings) {
                System.out.println("Division 3");
            } else {
                System.out.println("Division 4");
            }
        }
    }
}
