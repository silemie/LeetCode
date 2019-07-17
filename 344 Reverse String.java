class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        
        while(l <= r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            
            l++;
            r--;
        }
    }
}

/**
 * recursive way
 */

class Solution {
    public void reverseString(char[] s) {
        printHelper(0, s);
    }
    
    private void printHelper(int index, char[] s) {
        if(s.length == 0 || index >= s.length) {
            return;
        }
        
        char tmp = s[index];
        printHelper(index + 1, s);
        s[s.length - index - 1] = tmp;
    }
}