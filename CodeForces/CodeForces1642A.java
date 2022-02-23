import java.util.Scanner;
public class CodeForces1642A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test --> 0) {
            int ax = scanner.nextInt(), ay = scanner.nextInt();
            int bx = scanner.nextInt(), by = scanner.nextInt();
            int cx = scanner.nextInt(), cy = scanner.nextInt();

            if(ay == by && cy < ay) {
                System.out.println(Math.abs(ax - bx));
            } else if(by == cy && ay < by) {
                System.out.println(Math.abs(bx - cx));
            } else if(cy == ay && by < cy) {
                System.out.println(Math.abs(cx - ax));
            } else {
                System.out.println(0);
            }

        }
    }
}
