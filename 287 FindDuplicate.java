public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(check(nums, mid)) {
                //find larger number
                left = mid;
            } else {
                //find smaller number
                right = mid;
            }
        }
        
        if(!check(nums, left)) {
            return left;
        } else {
            return right;
        }
    }
    
    private boolean check(int[] nums, int mid) {
        int count = 0;
        for(int n : nums) {
            if(n <= mid) {
                count++;
            }
        }
        
        return count <= mid;
    }
}