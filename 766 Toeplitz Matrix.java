class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}