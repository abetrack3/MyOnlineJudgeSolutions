import java.util.Arrays;
import java.util.Scanner;

public class CodeForces1669G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test = sc.nextInt(); test --> 0;) {
            int rows = sc.nextInt(), columns = sc.nextInt();
            char[][] grid = new char[rows][];
            Arrays.setAll(grid, i -> grid[i] = sc.next().toCharArray());
            simulate(grid);
            for (char[] row : grid) {
                System.out.println(new String(row));
            }

        }
    }

    public static void simulate(char[][] grid) {
        for (int column = grid[0].length - 1; column >= 0; column--) {
            int emptyPosition = grid.length - 1, row = grid.length - 1;
            while (row != -1) {
                
                if (grid[row][column] == 'o') {
                    emptyPosition = row = row - 1;
                } else if (grid[row][column] == '*') {
                    char temp = grid[emptyPosition][column];
                    grid[emptyPosition][column] = grid[row][column];
                    grid[row][column] = temp;
                    emptyPosition--;
                    row--;
                } else {
                    row--;
                }

            }
        }
    }

}
