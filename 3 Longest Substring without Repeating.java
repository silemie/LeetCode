public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        int maxLength = 0;
        
        int l = 0;
        int[] freq = new int[256];
        int curLen = 0;
        
        char[] ch = s.toCharArray();
        
        for(int r = 0; r < ch.length; r++) {
            while(freq[ch[r]] != 0) {
                freq[ch[l]]--;
                l++;
            }
            
            curLen = r - l + 1;
            freq[ch[r]]++;
            
            if(curLen >= maxLength) {
                maxLength = curLen;
            }
        }
        
        return maxLength;
    }
}

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        int maxLength = 0;
        
        int l = 0;
        int r = 0;
        
        char[] ch = s.toCharArray();
        
        for(l = 0; l < ch.length; l++) {
            int[] freq = new int[256];
            int curLen = 0;
            r = l;
            while(r < ch.length && freq[ch[r]] == 0) {
                freq[ch[r]]++;
                curLen++;
                r++;
            }
            
            if(curLen >= maxLength) {
                maxLength = curLen;
            }
        }
        
        return maxLength;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null) {
            return 0;
        }
        
        char[] words = s.toCharArray();
        int[] used = new int[256];
        
        int left = 0;
        int curLen = 0;
        int maxLen = 0;
        
        for(int i = 0; i < words.length; i++) {
            char c = words[i];
            used[c]++;
            curLen++;
            
            while(used[c] > 1 && left < words.length) {
                curLen--;
                used[words[left]]--;
                //System.out.println("curlen:" + curLen + "left:" + words[left]);
                left++;
            }
            
            maxLen = Math.max(curLen, maxLen);
        }
        
        return maxLen;
        
    }
}