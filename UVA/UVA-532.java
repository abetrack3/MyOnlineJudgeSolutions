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
    
    public static int dirX[] = {0,0,0,0,1,-1};
    public static int dirY[] = {0,0,1,-1,0,0};
    public static int dirZ[] = {1,-1,0,0,0,0};
    
    public static void main(String[] args) throws Exception
    {
        run();
    }
    
    public static void run() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
        sc.nextLine();
        while (!(l == 0 & r == 0 & c == 0))
        {
            char G[][][] = new char[l][r][];
            boolean sNotFound = true;
            int z = 0, y = 0, x = 0;
            for(int i = 0; i < l; i++)
            {
                for(int j = 0; j < r; j++)
                {
                    String s = sc.nextLine();
                    G[i][j] = s.toCharArray();
                    if(sNotFound)
                    {
                        int index = s.indexOf('S');
                        if(index >= 0)
                        {
                            sNotFound = false;
                            z = i;
                            y = j;
                            x = index;
                        }
                    }
                }
                sc.nextLine();
            }
            bfs(G, z, y, x, l, r, c);
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            sc.nextLine();
        }
    }
    
    public static void bfs(char G[][][], int z, int y, int x, int l, int r, int c)
    {
        boolean escaped = false;
        int ans = -1;
        boolean visited[][][] = new boolean[l][r][c];
        ArrayList <Coordinate> queue = new ArrayList <Coordinate> ();
        queue.add(new Coordinate(z, y, x, 0));
        visited[z][y][x] = true;
        while (!queue.isEmpty() & !escaped)
        {
            Coordinate cc = queue.remove(0);
            visited[cc.z][cc.y][cc.x] = true;
            int z1, y1, x1;
            for(int i = 0; i < 6; i++)
            {
                z1 = dirZ[i] + cc.z;
                y1 = dirY[i] + cc.y;
                x1 = dirX[i] + cc.x;
                if(z1 < 0 || y1 < 0 || x1 < 0 || z1 >= l || y1 >= r || x1 >= c)
                    continue;
                if(visited[z1][y1][x1]) continue;
                if(G[z1][y1][x1] == '#')
                {
                    visited[z1][y1][x1] = true;
                    continue;
                }
                queue.add(new Coordinate(z1, y1, x1, cc.d + 1));
                visited[z1][y1][x1] = true;
                if(G[z1][y1][x1] == 'E')
                {
                    escaped = true;
                    ans = queue.get(queue.size() - 1).d;
                    break;
                }
            }
        }
        if(escaped) System.out.println("Escaped in " + ans + " minute(s).");
        else System.out.println("Trapped!");
    }
    
    static class Coordinate
    {
        int z, y, x, d;
        
        Coordinate(int zz, int yy, int xx, int dd)
        {
            z = zz;
            y = yy;
            x = xx;
            d = dd;
        }
    }
    
   
    
}
