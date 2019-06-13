
/*真正的双指针*/


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
       int l = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int cur = nums.length + 1;
        
        for(int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while(sum >= s) {
                cur = r - l + 1;
                sum -= nums[l];
                l++;
            }
            
            if(cur < min) {
                min = cur;
            }
            
        }
        
        if(cur == nums.length + 1) {min = 0;}
        
        return min;
    }
}

/*public class Solution {

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
}*/