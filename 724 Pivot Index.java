class Solution {
    public int pivotIndex(int[] nums) {
//         if(nums.length == 0) {
//             return -1;
//         }
//         int left = 0;
//         int right = nums.length - 1;
        
//         int rightSum = nums[right];
//         int leftSum = nums[left];
//         while(left < right) {
            
//             if(rightSum < leftSum) {
//                 right--;
//                 rightSum += nums[right];
//             } else if(rightSum > leftSum) {
//                 left++;
//                 leftSum += nums[left];
//             } else {
//                 right--;
//                 left++;
//                 leftSum += nums[left];
//                 rightSum += nums[right];
//             }
//         }
        
//         //System.out.println(rightSum);
//         //System.out.println(leftSum);
//         if(rightSum == leftSum) {
//             return left;
//         } else {
//             return -1;
//         }
        if(nums.length == 0) {
            return -1;
        }
        
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum == total - sum - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        
        return -1;
    }
}