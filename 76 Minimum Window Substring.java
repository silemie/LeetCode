public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        if(t.length == 0) 
        {
            return "";
        }
        
        int[] cntS = new int[256];//number of appearances of each leter in the window
        int[] cntT = new int[256];//how many times each letter apperars in target
        int k = 0;//number of target's unique Character
        
        for(int i = 0; i < 256; i++) 
        {
            cntS[i] = cntT[i] = 0;
        }//suggestion: 自己写initialization，因为有的语言编译器版本不是0
        
        for(char c : t) {
            ++cntT[c];
            if(cntT[c] == 1) {
                ++k;
            }
        }
        
        int C = 0;//number of target's unique characters we've collected in s[1 .. r-1]
        int ansl = -1, ansr = -1;
        int l,r = 0;
        //l: main pointer, left pointer, start position
        //r:scendary pointer, right pointer
        
        for(l = 0; l < s.length; ++l) {
            //insert into window
            while(r < s.length && C < k) {
                ++cntS[s[r]];
                if(cntS[s[r]] == cntT[s[r]]) {
                    ++C;
                }
                
                ++r;
            }
            
            if(C == k) {
                if(ansl == -1 || r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
            }
            
            //s[l] is now removed from the window;
            --cntS[s[l]];
            
            if(cntS[s[l]] == cntT[s[l]] - 1) {
                --C;
            }
        }
        
        if(ansl == -1) {
            return "";
        } else {
            return source.substring(ansl, ansr);
        }
    }
}