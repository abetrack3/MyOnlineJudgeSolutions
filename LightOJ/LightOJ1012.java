/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.Scanner;
import java.io.File;

public class Main
{
    
    public static int dirx[] = {-1, 0, 1, 0};
    public static int diry[] = {0, 1, 0, -1};
    
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
            int width = puttingvaluesinside.nextInt();
            int height = puttingvaluesinside.nextInt();
            boolean visited[] = new boolean[height * width];
            int x, y;
            x = y = 0;
            boolean flag = true;
            puttingvaluesinside.nextLine();
            char graph[][] = new char[height][];
            for(int j = 0; j < height; j++)
            {
                String s = puttingvaluesinside.nextLine();
                graph[j] = s.toCharArray();
                if(flag)
                {
                    int index = s.indexOf('@');
                    if(index >= 0)
                    {
                        y = j;
                        x = index;
                        flag = false;
                    }
                }
                
            }
            System.out.println("Case "+i+": "+solve(graph, x, y, visited));
        }
    }
    
    public static int solve(char graph[][], int x, int y, boolean visited[])
    {
        visited[getNode(x, y, graph[0].length)] = true;
        int count = 1;
        for(int i = 0; i < dirx.length; i++)
        {
            int x1 = x + dirx[i];
            int y1 = y + diry[i];
            if(x1 < 0 || x1 >= graph[0].length) continue;
            if(y1 < 0 || y1 >= graph.length) continue;
            if(visited[getNode(x1, y1, graph[0].length)]) continue;
            if(graph[y1][x1] == '.')
                count += solve(graph, x1, y1, visited);
        }
        return count;
    }
    
    public static int getNode(int x, int y, int width)
    {
        return y * width + x;
    }
    
}
