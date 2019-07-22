class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[][] matrix = new int[rowIndex + 2][rowIndex + 2];
        boolean[][] done = new boolean[rowIndex + 2][rowIndex + 2];
        
        for(int i = 1; i <= rowIndex + 1; i++) {
            for(int j = 1; j <= i; j++) {
                int num = generateHelper(i, j, matrix, done);
                matrix[i][j] = num;
                done[i][j] = true;
                if(i == rowIndex + 1) {
                    ans.add(num);
                }
            }
            
        }
        
        return ans;
    }
    
    private int generateHelper(int i, int j, int[][] matrix, boolean[][] done) {
        if(done[i][j]) {
            return matrix[i][j];
        }
        
        if(i == 1 || j == 1 || j == i) {
            return 1;
        }
        
        return generateHelper(i - 1, j - 1, matrix, done) + generateHelper(i - 1, j, matrix, done);
    }
        
}