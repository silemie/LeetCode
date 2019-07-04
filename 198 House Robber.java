public class Solution {

    public long houseRobber(int[] A) {
        // write your code here
        
        if(A.length == 0) {
            return 0;
        }
        
        long[] maxValue = new long[A.length + 1];
        maxValue[0] = 0;
        maxValue[1] = A[0];
        
        for(int i = 2; i < A.length + 1; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + A[i - 1]);
        }
        
        return maxValue[A.length];
    }
}