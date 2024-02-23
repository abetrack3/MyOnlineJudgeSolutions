import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            IntStream.range(0, sc.nextInt())
            .forEach(test -> {

                sc.nextInt();
                sc.nextLine();
                char[] tasks = sc.nextLine().toCharArray();

                boolean notSuspicious = true;
                boolean[] visited = new boolean[26];

                visited[tasks[0] - 65] = true;

                for (int index = 1; index < tasks.length; index++) {
                    
                    if (!visited[tasks[index] - 65]) {

                        visited[tasks[index] - 65] = true;

                    } else if (tasks[index] != tasks[index - 1]) {

                        notSuspicious = false;

                    }

                }

                System.out.println(notSuspicious ? "YES" : "NO");

            });

        }


    }

}
