class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null) {
            return 0;
        }
        
        int left = 0;
        int maxLen = 0;
        int maxRepeatedChars = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            maxRepeatedChars = Math.max(maxRepeatedChars, map.get(rightChar));
            
            if(i - left + 1 - maxRepeatedChars > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            
            maxLen = Math.max(maxLen, i - left + 1);
        }
        
        return maxLen;
    }
}