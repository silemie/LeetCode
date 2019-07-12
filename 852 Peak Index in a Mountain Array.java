class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        if(A.length == 0) {
            return 0;
        }
        
        if(A.length == 1) {
            return A[1];
        }
        
        int left = 1;
        int right = A.length - 1;
        
        while(left + 1< right) {
            int mid = left + (right - left) / 2;
            if(A[mid] > A[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(left < A.length - 1 && A[left] > A[left + 1]) {
            return left;
        } else {
            return right;
        }
    }
}