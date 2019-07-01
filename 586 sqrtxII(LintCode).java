public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        double l = 0, r = Math.max(1.0, x);
        double eps = 1e-12;
        
        while(l + eps < r) {
            double mid = l + (r - l) / 2;
            if(mid < x / mid) {
                l = mid;
            } else if(mid > x / mid) {
                r = mid;
            } else {
                return mid;
            }
        }
        
        return l;
    }
}