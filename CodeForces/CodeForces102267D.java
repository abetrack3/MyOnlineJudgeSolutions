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
import java.awt.Point;
 
public class Main
{
    public static void main(String[] args)
    {
        Scanner puttingvaluesinside = new Scanner(System.in);
        String grid[][] = new String[12][12];
        for(String x[] : grid)
            java.util.Arrays.fill(x, "");
//        grid[2][2] = grid[2][9] = grid[9][2] = grid[9][9] = 1;
grid[5][5] = grid[6][6] = grid[5][6] = grid[6][5] = "X";
grid[9][1] = grid[8][1] = grid[8][2] = "X";
grid[9][10] = grid[8][10] = grid[8][9] = "X";
generate(grid, 2, 2);
generate(grid, 2, 9);
generate(grid, 9, 2);
generate(grid, 9, 9);
int test = puttingvaluesinside.nextInt();
while (test --> 0)
{
    int row = puttingvaluesinside.nextInt() - 1;
    int column = puttingvaluesinside.nextInt() - 1;
    System.out.println(grid[row][column].length());
    System.out.println(grid[row][column]);
}
    }
    
    public static void generate(String [][] grid, int r, int c)
    {
        boolean visited[][] = new boolean[12][12];
        ArrayList<Point> queue = new ArrayList<Point>();
        visited[r][c] = true;
        grid[r][c] = "";
        queue.add(new Point(r, c));
        while (!queue.isEmpty())
        {
            Point p = queue.remove(0);
            visited[p.x][p.y] = true;
            
            int rr, cc, x = p.x, y = p.y;
            
            //up
            rr = x - 1; cc = y;
            if(rr >= 0 & rr < 12 & cc >= 0 & cc < 12)
                if(!grid[rr][cc].equals("X") && !visited[rr][cc])
                {
                    String s = "D" + grid[x][y];
                    if(s.length() < grid[rr][cc].length() || grid[rr][cc].equals(""))
                    {
                        grid[rr][cc] = s;
                        queue.add(new Point(rr, cc));
                        visited[rr][cc] = true;
                    }
                }
            //down
            rr = x + 1; cc = y;
            if(rr >= 0 & rr < 12 & cc >= 0 & cc < 12)
                if(!grid[rr][cc].equals("X") && !visited[rr][cc])
                {
                    String s = "U" + grid[x][y];
                    if(s.length() < grid[rr][cc].length() || grid[rr][cc].equals(""))
                    {
                        grid[rr][cc] = s;
                        queue.add(new Point(rr, cc));
                        visited[rr][cc] = true;
                    }
                }
            //left
            rr = x; cc = y - 1;
            if(rr >= 0 & rr < 12 & cc >= 0 & cc < 12)
                if(!grid[rr][cc].equals("X") && !visited[rr][cc])
                {
                    String s = "R" + grid[x][y];
                    if(s.length() < grid[rr][cc].length() || grid[rr][cc].equals(""))
                    {
                        grid[rr][cc] = s;
                        queue.add(new Point(rr, cc));
                        visited[rr][cc] = true;
                    }
                }
            //right
            rr = x; cc = y + 1;
            if(rr >= 0 & rr < 12 & cc >= 0 & cc < 12)
                if(!grid[rr][cc].equals("X") && !visited[rr][cc])
                {
                    String s = "L" + grid[x][y];
                    if(s.length() < grid[rr][cc].length() || grid[rr][cc].equals(""))
                    {
                        grid[rr][cc] = s;
                        queue.add(new Point(rr, cc));
                        visited[rr][cc] = true;
                    }
                }
        }
    }
    
}