class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || k == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int curLen = 0;
        int numOfChar = 0;
        int left = 0;
        
        int[] used = new int[256];
        
        char[] word = s.toCharArray();
        
        for(int i = 0; i < word.length; i++) {
            char c = word[i];
            used[c]++;
            curLen++;
            
            if(used[c] == 1) {
                numOfChar++;
            }
            
            while(numOfChar > k) {
                curLen--;
                used[word[left]]--;
                if(used[word[left]] < 1) {
                    numOfChar--;
                }
                left++;
            }
            
            if(numOfChar <= k) {
                maxLen = Math.max(curLen, maxLen);
            } 
        }
        
        return maxLen;
    }
}

// public class Solution {
//     /*
//      * @param s: A string
//      * @param k: An integer
//      * @return: An integer
//      */
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         // write your code here
//         int[] cnt = new int[256];
//         char[] sc = s.toCharArray();

//         int ans = 0;
//         int sum = 0;
//         for (int l = 0, r = 0; r < s.length(); r++) {
//             cnt[sc[r]]++;
//             if (cnt[sc[r]] == 1) {
//                 sum++;
//             }
//             while (sum > k) {
//                 cnt[sc[l]]--;
//                 if (cnt[sc[l]] == 0) {
//                     sum--;
//                 }
//                 l++;
//             }
//             ans = Math.max(ans, r - l + 1);
//         }
//         return ans;
//     }
// }
/*
My solution: too slow.. 
public class Solution {

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
}*/