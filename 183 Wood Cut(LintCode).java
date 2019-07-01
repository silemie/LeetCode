public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int l = 1, r = 0;
        int res = 0;
        
        for(int item : L) {
            r = Math.max(r, item);
        }
        
        //O(log2(max L)) * n
        while(l <= r) {
            //also l + 1 < r
            //看习惯，找一个顺手的，能解释清楚的
            int mid = (r - l) / 2 + l;
            if(count(L, mid) >= k) {
                //mid is a possible answer, but may be larger
                res = mid;
                l = mid + 1;
            } else {
                //mid is not an answer
                r = mid - 1;
            }
        }
        
        return res;
    }
    
    private int count(int[] L, int len) {
        int sum = 0;
        for(int item : L) {
            sum += item/len;
        }
        
        return sum;
    }
}