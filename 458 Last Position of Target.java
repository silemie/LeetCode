public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        
        if(nums.length == 0) {
            return -1;
        }
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid;
            } else {
                left = mid;
            }
        }
        
        
        
        if(nums[right] == target) {
            return right;
        }
        
        if(nums[left] == target) {
            return left;
        }
        
        return -1;
    }
}