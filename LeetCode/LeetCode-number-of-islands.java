public class Solution {

    public static final int[][] steps = {{0, -1}, // left
                                         {0,  1},   // right
                                         {1,  0},   // top
                                         {-1, 0}}; // bottom
    public static void main(String[] args) {
        
        // case variables
        char[][] grid;

        // case 1
        grid = new char[][]{{'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution().numIslands(grid));

        // case 2
        grid = new char[][]{{'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];

        int islanCount = 0;
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnCell = 0; columnCell < grid[0].length; columnCell++) {
                if (visited[rowIndex][columnCell] || grid[rowIndex][columnCell] == '0') {
                    continue;
                }
                traversGrid(grid, visited, rowIndex, columnCell);
                islanCount++;
            }
        }

        return islanCount;

    }

    public void traversGrid(char[][] grid, boolean[][] visited, int row, int column) {
        if (grid[row][column] == '0') {
            return;
        }

        visited[row][column] = true;

        for (int[] step : steps) {
            if (cellExistsAndNotVisited(visited, row + step[0], column + step[1])) {
                traversGrid(grid, visited, row + step[0], column + step[1]);
            }
        }


    }

    public boolean cellExistsAndNotVisited(boolean[][] visited, int row, int column) {

        int noOfRows = visited.length, noOfColumns = visited[0].length;

        if (row < 0 || row >= noOfRows || column < 0 || column >= noOfColumns) {
            return false;
        }

        return !visited[row][column];
    }

}