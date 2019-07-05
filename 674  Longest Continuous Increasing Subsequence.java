class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // write your code here
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        
        int max = 1;
        int[] maxLen = new int[n];
        maxLen[0] = 1;
        
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                maxLen[i] = maxLen[i - 1] + 1;
                max = Math.max(max, maxLen[i]);
            } else {
                maxLen[i] = 1;
            }
        }
        
         return max;
    }
}