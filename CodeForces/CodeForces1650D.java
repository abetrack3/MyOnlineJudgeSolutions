import java.util.Scanner;
import java.util.LinkedList;
public class CodeForces1650D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            int[] ans = new int[n];
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = n; i --> 0;) { list.addLast(scanner.nextInt()); }
            for(int i = n; i >= 1; i--) {
                while(list.getLast() != i) { 
                    list.addLast(list.removeFirst());
                    ans[i - 1]++; 
                }
                ans[i - 1] %= n;
                list.removeLast();
            }
            System.out.println(printArray(ans));
        }
    }

    public static String printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(" " + arr[i]);
        }
        return sb.toString();
    }

}