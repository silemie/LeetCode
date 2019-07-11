class Solution {
    public int searchInsert(int[] nums, int target) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        if(target < nums[0]) {
            return 0;
        }
        
        if(target > nums[nums.length - 1]) {
            return nums.length;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }
        
        if(nums[left] < target) {
            return left + 1;
        } else {
            return left;
        }
    }
}