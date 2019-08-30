class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if(s == null) {
            return 0;
        }
        
        int left = 0;
        int cur = 0;
        int max = 0;
        int chars = 0;
        
        char[] word = s.toCharArray();
        int[] used = new int[256];
        
        for(int i = 0; i < word.length; i++) {
            char c = word[i];
            cur++;
            used[c]++;
            
            if(used[c] == 1) {
                chars++;
            }
            
            while(chars > 2) {
                used[word[left]]--;
                cur--;
                
                if(used[word[left]] == 0) {
                    chars--;
                }
                
                left++;
            }
            
            if(chars <= 2) {
                max = Math.max(cur, max);
            }
        }
        
        return max;
    }
}