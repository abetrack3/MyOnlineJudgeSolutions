import java.util.HashSet;
import java.util.Scanner;
public class CodeForces1642B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            int val = set.size();
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                if(i != 0) sb.append(" ");
                sb.append(""+Math.max(i, val));
            }
            System.out.println(sb.toString());
        }
    }
}
