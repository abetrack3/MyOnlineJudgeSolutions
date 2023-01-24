import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minTime(int numberOfNodes, int[][] edges, List<Boolean> hasApple) {
        
        ArrayList<Integer>[] graph = buildGraph(numberOfNodes, edges, hasApple);

        return traverseDFS(graph, hasApple, 0, -1);

    }

    public int traverseDFS(ArrayList<Integer>[] graph, List<Boolean> hasApple, int currentNode, int parentNode) {
        int ans = 0;
        for (int nextNode : graph[currentNode]) {
            if (nextNode == parentNode) { continue; }
            ans += traverseDFS(graph, hasApple, nextNode, currentNode);
        }
        ans = (hasApple.get(currentNode) || ans > 0) && currentNode != 0? ans + 2 : ans;
        return ans;
    }

    public ArrayList<Integer>[] buildGraph(int numberOfNodes, int[][] edges, List<Boolean> hasApple) {

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

}