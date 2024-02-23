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
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            System.gc();
            
            //initial
            int u[] = new int[4];
            u[0] = sc.nextInt();
            u[1] = sc.nextInt();
            u[2] = sc.nextInt();
            u[3] = sc.nextInt();
            
            //final
            int v[] = new int[4];
            v[0] = sc.nextInt();
            v[1] = sc.nextInt();
            v[2] = sc.nextInt();
            v[3] = sc.nextInt();
            
            //forbidden
            boolean visited[][][][] = new boolean[10][10][10][10];
            int n = sc.nextInt();
            while (n-->0)
            {
                visited
                        [sc.nextInt()]
                        [sc.nextInt()]
                        [sc.nextInt()]
                        [sc.nextInt()] = true;
            }
            int ans = bfs(u, v, visited);
            System.out.println(ans);
            sc.nextLine();
            sc.nextLine();
        }
    }
    
    public static int bfs(int u[], int v[], boolean visited[][][][])
    {
        //quick corner case
        if(u[0] == v[0] & u[1] == v[1] & u[2] == v[2] & u[3] == v[3])
            return 0;
        
        boolean notFound = true;
        ArrayList <Configuration> queue = new ArrayList<Configuration>();
        queue.add(new Configuration(u[0], u[1], u[2], u[3], 0));
        visited[u[0]][u[1]][u[2]][u[3]] = true;
        
        while (!queue.isEmpty() & notFound)
        {
            Configuration c = queue.remove(0);
            visited[c.s1][c.s2][c.s3][c.s4] = true;
            int currentLevel = c.level;
            
            int x1, x2, x3, x4;
            
            //s1 left
            x1 = left(c.s1);
            x2 = c.s2;
            x3 = c.s3;
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s1 right
            x1 = right(c.s1);
            x2 = c.s2;
            x3 = c.s3;
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s2 left
            x1 = c.s1;
            x2 = left(c.s2);
            x3 = c.s3;
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s2 right
            x1 = c.s1;
            x2 = right(c.s2);
            x3 = c.s3;
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s3 left
            x1 = c.s1;
            x2 = c.s2;
            x3 = left(c.s3);
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s3 right
            x1 = c.s1;
            x2 = c.s2;
            x3 = right(c.s3);
            x4 = c.s4;
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s4 left
            x1 = c.s1;
            x2 = c.s2;
            x3 = c.s3;
            x4 = left(c.s4);
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
            
            //s4 right
            x1 = c.s1;
            x2 = c.s2;
            x3 = c.s3;
            x4 = right(c.s4);
            if(!visited[x1][x2][x3][x4])
            {
                queue.add(new Configuration(x1, x2, x3, x4, currentLevel + 1));
                visited[x1][x2][x3][x4] = true;
                if(x1 == v[0] & x2 == v[1] & x3 == v[2] & x4 == v[3])
                    return currentLevel + 1;
            }
        }
        return -1;
    }
    
    public static int left(int x)
    {
        return (x == 0) ? 9 : x - 1;
    }
    
    public static int right(int x)
    {
        return (x + 1) % 10;
    }
    
    static class Configuration
    {
        int s1;
        int s2;
        int s3;
        int s4;
        int level;
        
        Configuration(int a, int b, int c, int d, int l)
        {
            s1 = a;
            s2 = b;
            s3 = c;
            s4 = d;
            level = l;
        }
        
    }
    
}
