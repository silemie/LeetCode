class Solution {
    
    public int climbStairs(int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        int[] memo = new int[n + 1];
        
        memo[1] = 1;
        memo[2] = 2;
        
        return climbHelper(n, memo);
    }
    
    private int climbHelper(int n, int[] memo) {
        if(memo[n] != 0) {
            return memo[n];
        }
        
        int oneStep = climbHelper(n - 1, memo);
        int twoStep = climbHelper(n - 2, memo);
        
        memo[n] = oneStep + twoStep;
        
        return memo[n];
    }
}