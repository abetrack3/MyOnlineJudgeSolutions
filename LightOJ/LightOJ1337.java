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
import java.util.ArrayList;

public class Main
{
    
    public static int dy[] = {1, -1, 0, 0};
    public static int dx[] = {0, 0, 1, -1};
    
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 1; i <= test; i++)
        {
            System.gc();
            int height = sc.nextInt();
            int width = sc.nextInt();
            int queries = sc.nextInt();
            char g[][] = new char[height][];
            sc.nextLine();
            for(int j = 0; j < height; j++)
                g[j] = sc.nextLine().toCharArray();
            int ans[][] = solve(g);
            System.out.println("Case "+i+":");
            while(queries --> 0)
                System.out.println(ans[sc.nextInt() - 1][sc.nextInt() - 1]);
        }
    }
    
    public static int[][] solve(char g[][])
    {
        int ans[][] = new int[g.length][g[0].length];
        boolean flag1[][] = new boolean[g.length][g[0].length];
        boolean flag2[][] = new boolean[g.length][g[0].length];
        for(int i = 0; i < g.length; i++)
        {
            for(int j = 0; j < g[0].length; j++)
            {
                if(flag1[i][j]) continue;
                if(g[i][j] == '#'){flag1[i][j] = flag2[i][j] = true; continue;}
                int count = bfs(g, flag1, i, j);
                assignBFS(g, flag2, ans, i, j, count);
            }
        }
        return ans;
    }
    
    public static int bfs(char g[][], boolean flag[][], int i, int j)
    {
        ArrayList<Integer> queueY = new ArrayList<Integer>();
        ArrayList<Integer> queueX = new ArrayList<Integer>();
        int count = 0;
        flag[i][j] = true;
        queueX.add(j);
        queueY.add(i);
        while (!queueX.isEmpty())
        {
            int y = queueY.remove(0);
            int x = queueX.remove(0);
            flag[i][j] = true;
            if(g[y][x] == 'C') count++;
            for(int k = 0; k < 4; k++)
            {
                int y1 = y + dy[k];
                int x1 = x + dx[k];
                if(y1 < 0 || x1 < 0 || y1 >= g.length || x1 >= g[0].length)
                    continue;
                if(flag[y1][x1]) continue;
                if(g[y1][x1] == '#'){flag[y1][x1] = true; continue;}
                queueY.add(y1);
                queueX.add(x1);
                flag[y1][x1] = true;
            }
        }
        return count;
    }
    
    public static void assignBFS(char g[][], boolean flag[][], int ans[][], int i, int j, int count)
    {
        ArrayList<Integer> queueY = new ArrayList<Integer>();
        ArrayList<Integer> queueX = new ArrayList<Integer>();
        flag[i][j] = true;
        queueX.add(j);
        queueY.add(i);
        while (!queueX.isEmpty())
        {
            int y = queueY.remove(0);
            int x = queueX.remove(0);
            flag[i][j] = true;
            ans[y][x] = count;
            for(int k = 0; k < 4; k++)
            {
                int y1 = y + dy[k];
                int x1 = x + dx[k];
                if(y1 < 0 || x1 < 0 || y1 >= g.length || x1 >= g[0].length)
                    continue;
                if(flag[y1][x1]) continue;
                if(g[y1][x1] == '#'){flag[y1][x1] = true; continue;}
                queueY.add(y1);
                queueX.add(x1);
                flag[y1][x1] = true;
            }
        }
    }
    
}
