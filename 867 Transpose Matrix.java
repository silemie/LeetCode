class Solution {
    public int[][] transpose(int[][] A) {
        
        if(A == null || A.length == 0 || A[0].length == 0) {
            return new int[0][0];
        }
        
        int[][] ans = new int[A[0].length][A.length];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                ans[j][i] = A[i][j];
            }
        }
        
        return ans;
    }
}