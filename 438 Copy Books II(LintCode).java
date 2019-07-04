public class Solution {
    /**
     * @param n: An integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
        int left = 0;
        int right = 0;
        //int copier = times.length;
        
        for(int t : times) {
            right = Math.max(right, t * n);
        }
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(check(times, mid, n)) {
                //Need longer time
                left = mid;
            } else {
                //Need shorter time
                right = mid;
            }
        }
        
        if(!check(times, left, n)) {
            return left;
        } else {
            return right;
        }
    }
    
    private boolean check(int[] times, int limit, int n) {
        int books = 0;
        
        for(int t : times) {
            books += limit / t;
        }
        
        return books < n;
    }
}