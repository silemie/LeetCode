class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1 == null && s2 == null) {
            return true;
        }
        
        if(s1 == null | s2 == null) {
            return false;
        }
        
        int match = 0;
        int left = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int right = 0; right < s2.length(); right++) {
            char rightChar = s2.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                
                if(map.get(rightChar) == 0) {
                    match++;
                }
            }
            
            while(right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        match--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
            
            if(match == map.size()) {
                return true;
            }
        }
        
        return false;
    }
}