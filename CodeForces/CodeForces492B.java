import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            int numberOfLights = sc.nextInt();
            int lengthOfStreet = sc.nextInt();

            int[] lightPositions = IntStream.range(0, numberOfLights)
            .map(x -> sc.nextInt())
            .sorted()
            .toArray();

            int maxDist = 0;

            for (int index = 1; index < lightPositions.length; index++) {
                maxDist = Math.max(maxDist, lightPositions[index] - lightPositions[index - 1]);
            }

            double minRadius = maxDist / 2.0;

            int cornerDists = Math.max(lightPositions[0], lengthOfStreet - lightPositions[lightPositions.length - 1]);
            System.out.println(Math.max(minRadius, cornerDists));

        }

    }

}
