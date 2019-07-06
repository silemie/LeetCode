public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        
        if(s == null || s.equals("")) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int[] ways = new int[s.length() + 1];
        
        ways[0] = 1;
        if(chars[0] != '0') {
            ways[1] = 1;
        } else {
            ways[1] = 0;
        }
        
        for(int i = 2; i < chars.length + 1; i++) {
            if(chars[i - 1] != '0') {
                ways[i] = ways[i - 1];
            }
            
            int twodigit = chars[i - 1] - '0' + (chars[i - 2] - '0') * 10;
            //System.out.println(twodigit);
            if(twodigit >= 10 && twodigit <= 26) {
                ways[i] += ways[i - 2];
            }
        }
        
        return ways[s.length()];
    }
}