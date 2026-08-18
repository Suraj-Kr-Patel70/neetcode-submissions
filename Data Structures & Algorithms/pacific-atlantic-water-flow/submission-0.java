//import java.util.*;

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Start DFS from Pacific and Atlantic borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);       // Left
            dfs(heights, atlantic, i, n - 1); // Right
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);       // Top
            dfs(heights, atlantic, m - 1, j); // Bottom
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(
        int[][] heights,
        boolean[][] visited,
        int row,
        int col
    ) {

        // Already visited
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Boundary check
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // Neighbor must be >= current cell
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, visited, newRow, newCol);
        }
    }
}
