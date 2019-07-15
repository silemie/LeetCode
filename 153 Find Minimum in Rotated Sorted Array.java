class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int target = nums[right];
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] <= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}