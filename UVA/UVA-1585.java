import java.util.Scanner;

public class UVA1585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test = sc.nextInt(); test--> 0;) {
            long score = 0;
            char[] c = sc.next().toCharArray();
            int streak = 0;
            for (char x : c) {
                if (x == 'O') {
                    score += ++streak;
                } else {
                    streak = 0;
                }
            }
            System.out.println(score);
        }
    }
}
