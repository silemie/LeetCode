class Solution {
    public String complexNumberMultiply(String a, String b) {
        if(a.length() == 0 || b.length() == 0) {
            return "";
        }
        
        int[] first = parseComplex(a);
        int[] second = parseComplex(b);
        
        int coef = first[0] * second[0] - (first[1] * second[1]);
        int complex = first[0] * second[1] + first[1] * second[0];
        
        return coef + "+" + complex + "i";
        
    }
    
    private int[] parseComplex(String s) {
        String[] nums = s.split("\\+|i");
        
        int coef = Integer.parseInt(nums[0]);
        int complex = Integer.parseInt(nums[1]);
        
        int[] ans = new int[2];
        ans[0] = coef;
        ans[1] = complex;
        
        return ans;
    }
}