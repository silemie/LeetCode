class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) {
            return 1;
        }
        
        boolean isNeg = false;
        
        if(n < 0) {
            x = 1/x;
            n = - (n + 1); // avoid overflow
            isNeg = true;
        }
        
        double ans = 1;
        double copy = x;
        
        while(n != 0) {
            if(n % 2 == 1) {
                ans *= copy;
            }
            
            copy *= copy;
            n = n / 2;
        }
        
        if(isNeg) {
            ans *= x;
        }
        
        return ans;
    }
}