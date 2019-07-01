class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        
        int l = 1, r = x;
        
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(mid < x / mid) {
                l = mid;
            } else if (mid > x / mid){
                r = mid;
            } else {
                return mid;
            }
        }
        
        if(r > x / r) {
            return l;
        } else {
            return r;
        }
    }
}