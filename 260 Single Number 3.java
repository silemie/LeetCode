/**
 * Using XOR
 * 
 * Two steps:
 * 1. XOR all nums, then we get XOR of two nums we want
 *      find the arbitrary set bit
 * 2. Define all bits into two sets, one with the aforementioned bit set, 
 *      another with the aforementinoed bit unset.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }
        diff = Integer.highestOneBit(diff);
        
        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
}