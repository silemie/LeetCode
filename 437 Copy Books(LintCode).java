public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        
        int res = Integer.MAX_VALUE;
        //int time = 0;
        int left = 0, right = 0;
        
        //l and r are timestamps
        
        for(int i = 0; i < pages.length; i++) {
            right += pages[i];
        }

        while(left + 1 < right) {
            int time = left + (right - left) / 2;
            //assume n copiers will take some time to finish all works.
            //if n > k, it shows that we need longer time to complete works.
            //if n < k, it shows we might need shorter time to complete works.
            if(check(pages, time, k)) {
                left = time;
            } else {
                right = time;
            }
        }
        
        if(!check(pages, left, k)) {
            return left;
        } else {
            return right;
        }
    }
    
    //A function that returns true if the current time is shorter than optimal solution
    //return false if the current time is longer than the optimal solution
    private boolean check(int[] pages, int limit, int k) {
        int counter = 0;
        int sum = limit;
        for(int p : pages) {
            if(p > limit) {
                return true;
            }
            
            if(p > sum) {
                counter++;
                sum = limit;
            } 
            
            sum -= p;
        }
        
        return counter >= k;
    }
}