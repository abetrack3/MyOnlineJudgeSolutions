import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        
        // case variables
        int numberOfNodes;
        int[][] edges;
        String labels;

        // case 1
        numberOfNodes = 7;
        edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        labels = "abaedcd";
        System.out.println(Arrays.toString(new Solution().countSubTrees(numberOfNodes, edges, labels)));

        // case 2
        numberOfNodes = 4;
        edges = new int[][]{{0, 1}, {1, 2}, {0, 3}};
        labels = "bbbb";
        System.out.println(Arrays.toString(new Solution().countSubTrees(numberOfNodes, edges, labels)));

        // case 3
        numberOfNodes = 5;
        edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        labels = "aabab";
        System.out.println(Arrays.toString(new Solution().countSubTrees(numberOfNodes, edges, labels)));

    }

    public ArrayList<Integer>[] buildGraph(int numberOfNodes, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[numberOfNodes];
        
        for (int index = 0; index < graph.length; index++) {
            graph[index] = new ArrayList<>();
        }

        for (int[] eachEdge : edges) {
            int source = eachEdge[0];
            int destination = eachEdge[1];
            graph[source].add(destination);
            graph[destination].add(source);
        }

        return graph;
    }

    public int[] countSubTrees(int numberOfNodes, int[][] edges, String labels) {

        char[] labelsArray = labels.toCharArray();
        int[] labelCounter = new int[26];
        int[] result = new int[numberOfNodes];

        ArrayList<Integer>[] graph = buildGraph(numberOfNodes, edges);

        traverseDFS(graph, labelCounter, result, labelsArray, 0, -1);

        return result;
    }

    public void traverseDFS(
        ArrayList<Integer>[] graph,
        int[] labelCounter,
        int[] result,
        char[] labels,
        int currentNode,
        int parentNode
        ) {

            char currentLabel = labels[currentNode];
            int beforeDownTraverseLabelCount = labelCounter[currentLabel - 'a'];

            for (int nextNode : graph[currentNode]) {
                if (nextNode != parentNode) {
                    traverseDFS(graph, labelCounter, result, labels, nextNode, currentNode);
                }
            }

            labelCounter[currentLabel - 'a']++;
            result[currentNode] = labelCounter[currentLabel - 'a'] - beforeDownTraverseLabelCount;

    }

}
