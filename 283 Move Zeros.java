class Solution {
    public void moveZeroes(int[] nums) {
        
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while(nums[j] == 0 && j < nums.length - 1) {
                j++;
            }
            
            swap(nums, i - 1, j);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/** Better version
 * class Solution {
    public void moveZeroes(int[] nums) {
        
        int index = 0;
        
        for (int num : nums) {
            if(num != 0) {
                nums[index] = num;
                index++;
            }
        }
        
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}
 */