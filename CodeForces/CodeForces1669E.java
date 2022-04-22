import java.util.Scanner;

public class CodeForces1669E {

    public static final int START = 0, END = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test --> 0) {
            int n = sc.nextInt();
            int[] startsWithCounter = new int[11];
            int[] endsWithCounter = new int[11];
            int[][] startToEnd = new int[11][11];
            int[][] endToStart = new int[11][11];
            while (n --> 0) {
                 char[] twoLetterString = sc.next().toCharArray();
                 startsWithCounter[twoLetterString[START] - 'a']++;
                 endsWithCounter[twoLetterString[END] - 'a']++;
                 startToEnd[twoLetterString[START] - 'a'][twoLetterString[END] - 'a']++;
                 endToStart[twoLetterString[END] - 'a'][twoLetterString[START] - 'a']++;
            }
            long ans = calculatePairs(startsWithCounter, startToEnd) + calculatePairs(endsWithCounter, endToStart);
            System.out.println(ans);
        }
    }

    public static long calculatePairs(int[] counter, int[][] arr) {
        long ans = 0;
        for (int i = 0; i < 11; i++) {
            long sum = counter[i];
            for (int j = 0; j < 11; j++) {
                sum -= arr[i][j];
                ans += sum * (long)arr[i][j];
            }
        }
        return ans;
    }
}
