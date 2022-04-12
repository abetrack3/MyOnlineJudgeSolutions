import java.util.Scanner;

public class CodeForces342A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[8];
        for (int i = n; i --> 0;) {
            count[sc.nextInt()]++;
        }

        if (count[5] > 0 || count[7] > 0) {
            System.out.println(-1);
            return;
        }

        //1 3 6
        int count136 = Math.min(Math.min(count[1], count[3]), count[6]);
        count[1] -= count136;
        count[3] -= count136;
        count[6] -= count136;

        //1 2 6
        int count126 = Math.min(Math.min(count[1], count[2]), count[6]);
        count[1] -= count126;
        count[2] -= count126;
        count[6] -= count126;

        int count124 = Math.min(Math.min(count[1], count[2]), count[4]);
        count[1] -= count124;
        count[2] -= count124;
        count[4] -= count124;

        if (count124 + count126 + count136 != n / 3) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < count124; i++) {
                System.out.println("1 2 4");
            }
            for (int i = 0; i < count126; i++) {
                System.out.println("1 2 6");
            }
            for (int i = 0; i < count136; i++) {
                System.out.println("1 3 6");
            }
        }
    }

}
