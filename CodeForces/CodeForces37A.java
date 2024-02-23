import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static final int LARGEST_HEIGHT = 0;
    public static final int NUMBER_OF_TOWERS = 1;
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            int[] counters = new int[1001];
            int[] result = {0, 0};

            IntStream
            .range(0, sc.nextInt())
            .map(x -> sc.nextInt())
            .forEachOrdered(value -> {

                counters[value]++;

                if (counters[value] == 1) {
                    result[NUMBER_OF_TOWERS]++;
                }

                result[LARGEST_HEIGHT] = Math.max(counters[value], result[LARGEST_HEIGHT]);

            });

            System.out.println(result[LARGEST_HEIGHT] + " " + result[NUMBER_OF_TOWERS]);
        }

    }

}
