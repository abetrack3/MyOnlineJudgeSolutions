import java.util.Scanner;
public class CodeForces1650A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.nextLine();
        while (test --> 0) {
            char[] arr = scanner.nextLine().toCharArray();
            char c = scanner.nextLine().charAt(0);
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c && (i % 2 == 0) && (arr.length - i - 1) % 2 == 0) {
                    flag = false;
                    System.out.println("YES");
                    break;
                }
            }
            if (flag) { System.out.println("NO"); }
        }
        
    }
}
