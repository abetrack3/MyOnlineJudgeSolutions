import java.util.Scanner;
public class CodeForces1644B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test --> 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = arr.length - 1, j = 1; i >= 0; i--) arr[i] = j++;
            for(int i = arr.length - 1; i > 0; i--){
                printArray(arr);
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        System.out.print(arr[0]);
        for(int i = 1; i < arr.length; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }

}
