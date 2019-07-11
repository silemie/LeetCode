public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        
        if(n == 0) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i * i < n + 1; i++) {
            dp[i * i] = 1;
        }
        
        for(int i = 0; i < n + 1; i++) {
            for(int j = 1; j*j < i + 1; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}