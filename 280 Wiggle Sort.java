class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i+=2) {
            if(nums[i] <= nums[i - 1]) {
                swap(nums, i, i-1);
            } 
            
            if(i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                swap(nums, i, i+1);
            }
        }
    }

    /**
     * Using i % 2 == 1
     * 
     * for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 1) {
                if(nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if(i != 0 && nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
            if(i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                swap(nums, i, i+1);
            }
        }
     */

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}