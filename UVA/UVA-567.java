/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.ArrayList;
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
        int t = 1;
        while (sc.hasNextInt())
        {
            int nodeCount = 20;
            boolean G[][] = new boolean[nodeCount][nodeCount];
            int ans[][] = new int[nodeCount][nodeCount];
            for(int i = 0; i < nodeCount - 1; i++)
            {
                int n = sc.nextInt();
                while (n-->0)
                {
                    int k = sc.nextInt()-1;
                    G[i][k] = G[k][i] = true;
                }
            }
            build(G, ans);
//            for(int i = 0 ; i < nodeCount; i++)
//            {
//                System.out.print((G[i][0])?"  "+G[i][0]:" "+G[i][0]);
//                for(int j = 1; j < nodeCount; j++)
//                    System.out.print((G[i][j])?"  "+G[i][j]:" "+G[i][j]);
//                System.out.println();
//            }
//            System.out.println();
//            for(int i = 0; i < nodeCount; i++)
//            {
//                System.out.print((ans[i][0]<10)?"  "+ans[i][0]:" "+ans[i][0]);
//                for(int j = 1; j < nodeCount; j++)
//                    System.out.print((ans[i][j]<10)?"  "+ans[i][j]:" "+ans[i][j]);
//                System.out.println();
//            }
//            System.out.println();
            int q = sc.nextInt();
            System.out.println("Test Set #"+t);
            while (q-->0)
            {
                int from = sc.nextInt();
                int to = sc.nextInt();
                String f = (from < 10)?" "+from : ""+from;
                String too = (to < 10)?" "+to : ""+to;
                System.out.printf("%s to %s: %d\n", f, too, ans[from-1][to-1]);
            }
            System.out.println();
            
            t++;
        }
    }
    
    public static void build(boolean G[][], int ans[][])
    {
        for(int i = 0; i < G.length; i++)
            bfs(G, ans, i);
    }
    
    public static void bfs(boolean G[][], int ans[][], int start)
    {
        boolean visited[] = new boolean[G.length];
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> depth = new ArrayList<Integer>();
        queue.add(start);
        depth.add(0);
        visited[start] = true;
        while (!queue.isEmpty())
        {
            int currentNode = queue.remove(0);
            int currentDepth = depth.remove(0);
            visited[currentNode] = true;
            for(int i = 0; i < G.length; i++)
            {
                if(i == currentNode) continue;
                if(!G[currentNode][i]) continue;
                if(visited[i]) continue;
                queue.add(i);
                depth.add(currentDepth + 1);
                ans[start][i] = currentDepth + 1;
                visited[i] = true;
            }
        }
    }
    
}
