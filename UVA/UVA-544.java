import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roads = sc.nextInt();
        sc.nextLine();
        int testCase = 1;
        while (!(cities == 0 & roads == 0))
        {
            int g[][] = new int[cities][cities];
            for(int x[] : g)
                java.util.Arrays.fill(x, -1);
            HashMap<String, Integer> label = new HashMap<String, Integer>();
            for(int i = 0; i < roads; i++)
            {
                String f = sc.next();
                String t = sc.next();
                int w = Integer.parseInt(sc.next());
                int from = 0, to = 0;
                if(label.containsKey(f))
                    from = label.get(f);
                else
                    label.put(f, from = label.size());
                if(label.containsKey(t))
                    to = label.get(t);
                else
                    label.put(t, to = label.size());
                g[from][to] = g[to][from] = Math.max(w, g[from][to]);
            }
            int start = label.get(sc.next());
            int destination = label.get(sc.next());
            int ans = -1;
            ans = maximumSpanningTreePrim(g, start, destination);
            System.out.printf("Scenario #%d\n%d tons\n\n", testCase, ans);
            
            cities = sc.nextInt();
            roads = sc.nextInt();
            sc.nextLine();
            testCase++;
        }
    }
    
    public static int maximumSpanningTreePrim(int g[][], int start, int dest)
    {
        int key[] = new int[g.length];
        int backTrack[] = new int[g.length];
        boolean keySet[] = new boolean[g.length];
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    int a = key[x];
                    int b = key[y];
                    return (a == b) ? 0 : (a < b) ? 1 : -1;
                }});
        java.util.Arrays.fill(key, Integer.MIN_VALUE);
        java.util.Arrays.fill(backTrack, -1);
        key[dest] = Integer.MAX_VALUE;
        keySet[dest] = true;
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            keySet[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(g[current][i] == -1) continue;
                if(!keySet[i] & key[i] < g[current][i])
                {
                    queue.remove(i);
                    key[i] = g[current][i];
                    backTrack[i] = current;
                    queue.add(i);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        int pointer = start;
        while (pointer != dest)
        {
            ans = Math.min(ans, key[pointer]);
            pointer = backTrack[pointer];
        }
        return ans;
    }
    
}
