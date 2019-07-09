class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[] maxLine = new int[n];
        int[] maxCol = new int[m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxLine[i] = Math.max(maxLine[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        
        int incre = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int max = Math.min(maxLine[i], maxCol[j]);
                //System.out.println(max);
                incre += max - grid[i][j];
            }
        }
        
        return incre;
    }
}