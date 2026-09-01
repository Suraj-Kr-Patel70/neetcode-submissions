class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1. Check if first row contains 0
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // 2. Check if first column contains 0
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // 3. Use first row and first column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. Set marked rows to 0
        for (int i = 1; i < rows; i++) {

            if (matrix[i][0] == 0) {

                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. Set marked columns to 0
        for (int j = 1; j < cols; j++) {

            if (matrix[0][j] == 0) {

                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 6. Finally handle first row
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 7. Finally handle first column
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}