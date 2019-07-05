public class Solution {
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if(matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maximal = new int[m][n];
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        
        int max = 0;
        
        
        for(int p = 0; p < m; p++) {
            for(int q = 0; q < n; q++) {
                if(matrix[p][q] == 0) {
                    
                    maximal[p][q] = 0;
                    up[p][q] = 1;
                    left[p][q] = 1;
                    
                    if(p > 0) {
                        up[p][q] = up[p - 1][q] + 1;
                    }
                    if(q > 0) {
                        left[p][q] = left[p][q - 1] + 1;
                    }
                    
                } else {
                    maximal[p][q] = 1;
                    up[p][q] = left[p][q] = 0;
                    
                    if(p > 0 && q > 0) {
                        maximal[p][q] = Math.min(maximal[p - 1][q - 1], Math.min(left[p][q - 1], up[p - 1][q])) + 1;
                    }
                    
                    max = Math.max(max, maximal[p][q]);
                }
                
            }
        }
        
        return max * max;
    }
}