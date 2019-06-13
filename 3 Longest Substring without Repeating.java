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