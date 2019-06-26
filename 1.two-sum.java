import java.util.HashSet;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            if(hash.containsKey(target - nums[i])){
                ans[0] = hash.get(target - nums[i]);
                ans[1] = i;
            }

            hash.put(nums[i], i);
        }

        return ans;

    }
}

