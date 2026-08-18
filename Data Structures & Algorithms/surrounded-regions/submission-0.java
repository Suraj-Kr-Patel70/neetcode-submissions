class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // 1. Process left and right borders
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // 2. Process top and bottom borders
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // 3. Convert cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    // Surrounded region
                    board[i][j] = 'X';

                } else if (board[i][j] == '#') {
                    // Safe region
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        // Only process O
        if (board[row][col] != 'O') {
            return;
        }

        // Mark as safe
        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col);

        // Down
        dfs(board, row + 1, col);

        // Left
        dfs(board, row, col - 1);

        // Right
        dfs(board, row, col + 1);
    }
}
