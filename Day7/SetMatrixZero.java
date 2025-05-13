package Day7;

class SetMatrixZero {

    public static void markRow(int[][] matrix, int n, int m, int row){
        for (int j = 0; j < m; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -999;
            }
        }
    }

    public static void markCol(int[][] matrix, int n, int m, int col) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -999;
            }
        }
    }

    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -999) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}