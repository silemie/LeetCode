class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(sum[i] - k)) {
                max = Math.max(max, i - map.get(sum[i] - k));
            }
            
            if(!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
        }
        
        return max;
    }
}