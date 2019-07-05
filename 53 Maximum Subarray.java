public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if(nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int[] max = new int[nums.length];
        int maxVal = max[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
            maxVal = Math.max(maxVal, max[i]);
        }
        
        return maxVal;
    }
    
}