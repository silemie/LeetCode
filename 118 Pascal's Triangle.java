class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0) {
            return ans;
        }
        
        int cols = 1;
        int[][] matrix = new int[numRows + 1][numRows + 1];
        boolean[][] done = new boolean[numRows + 1][numRows + 1];
        for(int i = 1; i <= numRows; i++) {
            ArrayList<Integer> level = new ArrayList<>();
            for(int j = 1; j <= cols; j++) {
                int num = generateHelper(i, j, matrix, done);
                matrix[i][j] = num;
                done[i][j] = true;
                level.add(num);
            }
            ans.add(level);
            cols += 1;
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