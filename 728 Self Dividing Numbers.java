class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if(left > right) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = left; i < right + 1; i++) {     
            int count = 0;
            String num = Integer.toString(i);
            for(int k = 0; k < num.length(); k++) {
                char digit = num.charAt(k);
                if(digit == '0' || i % Character.getNumericValue(digit) != 0) {
                } else {
                    count++;
                }
            }
            
            if(count == num.length()) {
                ans.add(i);   
            }
        }
        
        return ans;
    }
}