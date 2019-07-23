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

/* 自己写的
class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) {
            return 1;
        }
        
        boolean isNeg = false;
        
        if(n < 0) {
            isNeg = true;
            x = 1/x;
            n = -(n + 1); //avoid the maximum neg num overflowing   
        }
        
        double base = x;
        double ans = 1;

        while(n > 0) {
            //System.out.println(n);
            if(n % 2 == 1) {
                ans *= base;
                //System.out.println(ans);
            }
            
            base *= base;
            n /= 2;
        }
        
        if(isNeg) {
            ans *= x;
        }
        
        return ans;
    }
}
*/