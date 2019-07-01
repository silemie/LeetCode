public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] A, int k) {
        // write your code here
        int i;
        double start, stop, mid;
        
        start = stop = A[0];
        
        for(i = 0; i < A.length; i++) {
            start = Math.min(A[i],start);
            stop = Math.max(A[i],stop);
        }
        
        while(start + 1e-5 < stop) {
            mid = (start + stop) / 2;
            if(canFind(A, k, mid)) {
                start = mid;
            } else {
                stop = mid;
            }
        }
        
        return start;
    }
    
    private boolean canFind(int[] A, int k, double T) {
        int i;
        double rightSum = 0, leftSum = 0, minLeftSum = 0;
        for(i = 0; i < k; i++) {
            rightSum += A[i] - T;
        }
        
        for(i = k; i <= A.length; i++) {
            if(rightSum - minLeftSum >= 0) {
                return true;
            }
            
            if(i < A.length) {
                rightSum += A[i] - T;
                leftSum += A[i - k] - T;
                minLeftSum = Math.min(leftSum, minLeftSum);
            }
        }
        
        return false;
    }
}