public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if(nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(mid > 0 && nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(nums[left] > nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}