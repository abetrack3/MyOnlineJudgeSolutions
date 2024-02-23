import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            int numberOfNodes = sc.nextInt();

            ArrayList<Integer>[] graph = buildGraph(sc, numberOfNodes);
            int[] targetColors = new int[numberOfNodes + 1];
            int[] currentColors = new int[numberOfNodes + 1];
            boolean[] visited = new boolean[numberOfNodes + 1];
            for (int index = 1; index <= numberOfNodes; index++) {
                targetColors[index] = sc.nextInt();
            }
            
            System.out.println(solveDfs(
                graph,
                1,
                1,
                targetColors,
                currentColors,
                visited
            ));

        }

    }

    public static ArrayList<Integer>[] buildGraph(Scanner sc, int numberOfNodes) {

        ArrayList<Integer>[] graph = new ArrayList[numberOfNodes + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < numberOfNodes; i++) {
            int val = sc.nextInt();
            graph[i+1].add(val);
            graph[val].add(i+1);
        }

        return graph;

    }

    public static int solveDfs(
        ArrayList<Integer>[] graph,
        int parentNode,
        int currentNode,
        int[] targetColors,
        int[] currentColors,
        boolean[] visited
    ) {

        visited[currentNode] = true;

        int result = 0;

        currentColors[currentNode] = currentColors[parentNode];

        if (currentColors[currentNode] != targetColors[currentNode] || currentNode == 1) {
            currentColors[currentNode] = targetColors[currentNode];
            result++;
        }

        for (int index = 0; index < graph[currentNode].size(); index++) {

            int adjacents = graph[currentNode].get(index);

            if (adjacents == parentNode || visited[adjacents]) {
                continue;
            }

            result += solveDfs(graph, currentNode, adjacents, targetColors, currentColors, visited);

        }

        return result;

    }

}
