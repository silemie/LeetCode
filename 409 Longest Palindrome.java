public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if(s.equals("")) {
            return 0;
        }
        HashSet<Character> hash = new HashSet<>();
        char[] chars = s.toCharArray();
        int pair = 0;
        
        for(char c : chars) {
            if(!hash.add(c)) {
                hash.remove(c);
                pair++;
            }
        }
        
        if(hash.size() == 0) {
            return pair * 2;
        } else {
            return (pair * 2) + 1;
        }
        
    }
}