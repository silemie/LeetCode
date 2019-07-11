class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers.length == 0) {
            return new int[0];
        }
        
        int[] ans = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            int index = doBinarySearch(numbers, i, target);
            if(index != -1) {
                ans[0] = i + 1;
                ans[1] = index + 1;
                break;
            }
        }
        
        return ans;
    }
    
    private int doBinarySearch(int[] nums, int i, int target) {
        int goal = target - nums[i];
        
        int left = i + 1;
        int right = nums.length - 1;
        
        while(left + 1< right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > goal) {
                right = mid;
            } else if(nums[mid] < goal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        if(left < nums.length && nums[left] == goal) {
            return left;
        }
        if(right < nums.length && nums[right] == goal) {
            return right;
        }
        
        return -1;
    }
}