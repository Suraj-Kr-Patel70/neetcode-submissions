

class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1. Add all treasure chests to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // 2. Multi-source BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                // Skip walls and already visited cells
                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // Distance = current distance + 1
                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}