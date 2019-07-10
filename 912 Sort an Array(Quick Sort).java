class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }
        
        quickSort(nums);
        return nums;
    }
    
    private void quickSort(int[] nums) {
        quickHelper(nums, 0, nums.length - 1);
    }
    
    private void quickHelper(int[] nums, int left, int right) {
        if(left > right) {
            return ;
        }
        
        int pivot = partition(nums, left, right);
        quickHelper(nums, left, pivot - 1);
        quickHelper(nums, pivot + 1, right);
    }
    
    private int partition(int[] nums, int left, int right) {
        int randomPivot = left + (int)(Math.random() * (right - left + 1));
        swap(nums, left, randomPivot);
        
        int index = left + 1;
        for(int i = left + 1; i < right + 1; i++) {
            if(nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        
        index--;
        swap(nums, left, index);
        
        return index;
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}