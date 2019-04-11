/**
 * Using XOR to solve this problem.
 * bitwise XOR: exclusive OR
 * 1 ^ 1 = 0
 * 0 ^ 0 = 0
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * 
 * Thus, 
 * N ^ 0 = N
 * N ^ N = 0
 * 
 * N1 ^ N2 ^ N3 ^ N4 ... ^ N5 = 0 ^ 0 ^ 0 ... ^ N = N
 */

class Solution {
    public int singleNumber(int[] nums) {
        int solution = 0;
        for(int i = 0; i < nums.length; i++) {
            solution ^= nums[i];
        }

        return solution;
    }
}

