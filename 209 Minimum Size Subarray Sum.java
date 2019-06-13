public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        
        int l; // main pointer
        int r; // secondary pointer
        int min = Integer.MAX_VALUE;
        
        for(l = 0; l < nums.length; l++) {
            int sum = 0;
            r = l;
            while(r < nums.length && sum < s) {
                sum += nums[r];
                r++;
            }
            
            int cur = r - l;
            
            if(sum >= s && cur < min) {
                min = cur;
            }
            
        }
        
        if(min == Integer.MAX_VALUE) {min = -1;}
    
        return min;
    }
}