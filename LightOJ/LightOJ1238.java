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
import java.io.File;

public class Main
{
    
    public static int x[] = new int[3];
    public static int y[] = new int[3];
    public static int dirx[] = {-1, 0, 0, 1};
    public static int diry[] = {0, 1, -1, 0};
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        int q = puttingvaluesinside.nextInt();
        for(int i = 1; i <= q; i++)
        {
            int height = puttingvaluesinside.nextInt();
            int width = puttingvaluesinside.nextInt();
            puttingvaluesinside.nextLine();
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;
            char graph[][] = new char[height][];
            for(int j = 0; j < height; j++)
            {
                String s = puttingvaluesinside.nextLine();
                graph[j] = s.toCharArray();
                if(flag1)
                {
                    int index = s.indexOf('a');
                    if(index >= 0)
                    {
                        x[0] = index;
                        y[0] = j;
                        flag1 = false;
                    }
                }
                if(flag2)
                {
                    int index = s.indexOf('b');
                    if(index >= 0)
                    {
                        x[1] = index;
                        y[1] = j;
                        flag2 = false;
                    }
                }
                if(flag3)
                {
                    int index = s.indexOf('c');
                    if(index >= 0)
                    {
                        x[2] = index;
                        y[2] = j;
                        flag3 = false;
                    }
                }
            }
            System.out.println("Case "+i+": "+solve(graph));
//            for(char x[] : graph)
//                System.out.println(java.util.Arrays.toString(x));
//            for(int g : x)
//                System.out.print(g+" ");
//            System.out.println();
//            for(int g : y)
//                System.out.print(g+" ");
//            System.out.println();
        }
    }
    
    public static int solve(char graph[][])
    {
        int ans = bfs(graph, x[0], y[0]);
        ans = Math.max(ans, bfs(graph, x[1], y[1]));
        ans = Math.max(ans, bfs(graph, x[2], y[2]));
        return ans;
    }
    
    public static int getNode(int x, int y, int width)
    {
        return y * width + x;
    }
    
    public static int bfs(char graph[][], int x, int y)
    {
        if(graph[y][x] == 'h') return 0;
        boolean visited[] = new boolean[graph.length * graph[0].length];
        visited[getNode(x, y, graph[0].length)] = true;
        ArrayList <Integer> queueX = new ArrayList<Integer>();
        ArrayList <Integer> queueY = new ArrayList<Integer>();
        queueX.add(x);
        queueY.add(y);
        ArrayList <Integer> depth = new ArrayList<Integer>();
        depth.add(0);
        while (queueX.size() != 0)
        {
            int pointer = 4;
            int x0 = queueX.get(0);
            int y0 = queueY.get(0);
            while (pointer --> 0)
            {
                int x1 = x0 + dirx[pointer];
                int y1 = y0 + diry[pointer];
                if(x1 < 0 || x1 >= graph[0].length) continue;
                if(y1 < 0 || y1 >= graph.length) continue;
                if(visited[getNode(x1, y1, graph[0].length)]) continue;
                if(graph[y1][x1] == 'h') return depth.get(0) + 1;
                if(
                        graph[y1][x1] == '.'
                        ||
                        graph[y1][x1] == 'a'
                        ||
                        graph[y1][x1] == 'b'
                        ||
                        graph[y1][x1] == 'c'
                        
                    )
                {
                    queueX.add(x1);
                    queueY.add(y1);
                    depth.add(depth.get(0) + 1);
                    visited[getNode(x1, y1, graph[0].length)] = true;
                }
            }
            queueX.remove(0);
            queueY.remove(0);
            depth.remove(0);
        }
        return -1;
    }
    
}
