class Solution {

    int[][] dp;
    int[][] matrix;

    int rows;
    int cols;

    int[][] directions = {
        {1, 0},   // Down
        {-1, 0},  // Up
        {0, 1},   // Right
        {0, -1}   // Left
    };

    public int longestIncreasingPath(int[][] matrix) {

        this.matrix = matrix;

        rows = matrix.length;
        cols = matrix[0].length;

        dp = new int[rows][cols];

        int result = 0;

        // Try starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        return result;
    }

    private int dfs(int i, int j) {

        // Already calculated
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // Path contains the current cell
        int length = 1;

        for (int[] dir : directions) {

            int ni = i + dir[0];
            int nj = j + dir[1];

            // Check boundaries
            if (ni < 0 || ni >= rows ||
                nj < 0 || nj >= cols) {
                continue;
            }

            // Must be strictly increasing
            if (matrix[ni][nj] > matrix[i][j]) {
                length = Math.max(
                    length,
                    1 + dfs(ni, nj)
                );
            }
        }

        dp[i][j] = length;

        return length;
    }
}
