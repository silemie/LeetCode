class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();  
        if(s == null | p == null) {
            return ans;
        }
        
        int left = 0;
        int match = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        char[] source = s.toCharArray();
        char[] target = p.toCharArray();
        
        for(int i = 0; i < target.length; i++) {
            char c = target[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int right = 0; right < source.length; right++) {
            char rightChar = source[right];
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) {
                    match++;
                }
            }
            
            if(right - left + 1 > target.length) {
                char leftChar = source[left];
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) == 1) {
                        match--;
                    }
                }
                left++;
            }
            
                        
            if(match == map.size()) {
                ans.add(left);
            }
        }
        
        return ans;
    }
}