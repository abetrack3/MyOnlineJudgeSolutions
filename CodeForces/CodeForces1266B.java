import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.LongStream;

public class Main {

    public static final int[] topSides = {20, 19, 18, 17, 16, 15};

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            LongStream
            .range(0, sc.nextLong())
            .map((x) -> sc.nextLong())
            .forEachOrdered((long x) -> {

                AtomicBoolean result = new AtomicBoolean(false);

                Arrays
                .stream(topSides)
                .forEachOrdered(topFacingDiceSum -> {

                    long temp = x - topFacingDiceSum;

                    if (temp % 14 == 0 && temp >= 0) {
                        result.set(true);
                    }

                });

                System.out.println(result.get() ? "YES" : "NO");

            });

        }
        
    }
}
