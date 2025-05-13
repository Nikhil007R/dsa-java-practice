package Day7;

class RotateImage {
    public void rotate(int[][] matrix) {

        // Optimal T.C -> O(N2)  S.C -> O(1);

        int n = matrix.length;
        int m = matrix[0].length;
        // first transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // then reversing har ek row mai.
        for(int row=0; row<n; row++){
            int start = 0;
            int end = m-1;

            while(start <= end){
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;
                start++;
                end--;
            }
        }

        // Brute force Approach  T.C -> O(N2)  S.C -> O(N2)

        // int n = matrix.length;
        // int m = matrix[0].length;

        // int arr[][] = new int[n][m];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         arr[j][n-1-i] = matrix[i][j];
        //     }
        // }
        // // temp ki values real matrix mai daaldi
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m;j++){
        //         matrix[i][j] = arr[i][j];
        //     }
        // }

    }
}
