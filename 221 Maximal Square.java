class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxSq = new int[m][n];
        
        int max = 0;
        
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                maxSq[i][0] = 1;
                max = 1;
            } else {
                maxSq[i][0] = 0;
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == '1') {
                maxSq[0][j] = 1;
                max = 1;
            } else {
                maxSq[0][j] = 0;
            }
        }
        
        for(int p = 1; p < m; p++) {
            for(int q = 1; q < n; q++) {
                if(matrix[p][q] == '1') {
                    maxSq[p][q] = Math.min(maxSq[p - 1][q - 1], maxSq[p - 1][q]);
                    maxSq[p][q] = Math.min(maxSq[p][q], maxSq[p][q - 1]) + 1;
                    max = Math.max(maxSq[p][q], max);
                } else {
                    maxSq[p][q] = 0;
                }
            }
        }
        
        return max * max;
    }
}