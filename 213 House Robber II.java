class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        
        if(n == 1) {
            return nums[0];
        }
        
        return Math.max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
        
    }
    
    private int robber(int[] nums, int begin, int end) {
        int[] maxValue = new int[nums.length];
        if(begin == end) {
            return nums[end];
        }
        
        if(begin + 1 == end) {
            return Math.max(nums[begin], nums[end]);
        }
        
        maxValue[0] = 0;
        maxValue[1] = nums[begin];
        
        for(int i = 2; i < nums.length; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + nums[begin + i - 1]);
        }
        
        return maxValue[nums.length - 1];
    }
}