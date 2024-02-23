import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int[] currentTime = (
                Arrays
                .stream(sc.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray()
            );
            int minimumMinutes = 0;
            while (!isPalindrome(currentTime)) {
                
                minimumMinutes++;
                incrementTimeByOneMinute(currentTime);

            }

            System.out.println(minimumMinutes);
        }

    }

    public static boolean isPalindrome(int[] currentTime) {

        return (currentTime[0] / 10) == (currentTime[1] % 10) && (currentTime[0] % 10) == (currentTime[1] / 10);

    }

    public static void incrementTimeByOneMinute(int[] currentTime) {

        boolean hourIncrement = false;

        if (currentTime[1] == 59) {
            hourIncrement = true;
        }

        currentTime[1] = (currentTime[1] + 1) % 60;

        if (hourIncrement) {
            currentTime[0] = (currentTime[0] + 1) % 24;
        }

    }

}

