import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int testCases = 1;
        while (size != 0)
        {
            int x[] = new int[size];
            int y[] = new int[size];
            double g[][] = new double[size][size];
            x[0] = sc.nextInt();
            y[0] = sc.nextInt();
            for(int i = 1; i < size; i++)
            {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                for(int j = 0; j < i; j++)
                {
                    g[i][j] = g[j][i] = Math.sqrt
                        (
                            (x[i] - x[j]) * (x[i] - x[j])
                                +
                            (y[i] - y[j]) * (y[i] - y[j])
                        );
                }
            }
            sc.nextLine();
            sc.nextLine();
            double ans = -1;
            ans = mstPrim(g);
            System.out.printf("Scenario #%d\nFrog Distance = %.3f\n\n",
                    testCases++, ans);
            size = sc.nextInt();
            
        }
    }
    
    public static double mstPrim(double g[][])
    {
        double key[] = new double[g.length];
        int backTrack[] = new int[g.length];
        boolean keySet[] = new boolean[g.length];
        java.util.Arrays.fill(key, Double.MAX_VALUE);
        java.util.Arrays.fill(backTrack, -1);
        key[0] = 0;
        keySet[0] = true;
        PriorityQueue <Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    double a = key[x];
                    double b = key[y];
                    return (a == b) ? 0 : (a < b) ? -1 : 1;
            }});
        for(int i = 0; i < g.length; i++)
            queue.add(i);
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            keySet[current] = true;
            for(int i = 0; i < g.length; i++)
            {
                if(current == i) continue;
                if(!keySet[i] & g[current][i] < key[i])
                {
                    queue.remove(i);
                    key[i] = g[current][i];
                    backTrack[i] = current;
                    queue.add(i);
                }
            }
        }
        double ans = 0;
        int pointer = 1;
        while (pointer != 0)
        {
            ans = Math.max(ans, key[pointer]);
            pointer = backTrack[pointer];
        }
        return ans;
    }
    
}
