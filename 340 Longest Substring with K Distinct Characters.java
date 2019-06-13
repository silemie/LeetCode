public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        int r, l;
        char[] ch = s.toCharArray();
        int maxLen = 0;
        
        for(l = 0; l < ch.length; l++) {
            //Main pointer only walks one step 
            int counter = 0;
            int curLen = 0;
            int[] freq = new int[256];
            r = l;
            while(counter <= k && r < ch.length) {
                if(freq[ch[r]] == 0) {
                    counter++;
                    if(counter > k) {break;}
                }
                freq[ch[r]]++;
                r++;
                curLen++;
            }
            
            if (curLen > maxLen) {
                maxLen = curLen; 
            }
        }
        
        return maxLen;
    }
}