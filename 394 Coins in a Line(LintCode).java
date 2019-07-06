public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        //举个例子：f(4)状态和f(3)与f(2)有关系

        //dp[0] = false
        //dp[1] = true
        //dp[2] = true
        //dp[i] = (!dp[i - 1]) || (!dp[i - 2])
        
        //Answer = dp[n]
        
        if(n == 0) {
            return false;
        }
        
        if(n == 1 || n == 2) {
            return true;
        }
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        
        for(int i = 3; i < n + 1; i++) {
            dp[i] = (!dp[i - 1]) || (!dp[i - 2]);
        }
        
        return dp[n];
    }
}