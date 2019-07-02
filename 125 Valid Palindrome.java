public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return true;
        }
        
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        String valid = "";
        for(int i = 0; i < chars.length; i++) {
            if(isValid(chars[i])) {
                valid += chars[i];
            }
        }
    
        //System.out.println(valid.length());
        //System.out.println(valid.length() / 2);
        
        Stack<Character> stack = new Stack<>();
        for(int j = 0; j < valid.length() / 2; j++) {
            //in sample case, max j = 9;
            stack.push(valid.charAt(j));
        }
        
        //System.out.println(stack.peek());
        int len = 0;
        if(valid.length() % 2 == 0) {
            //j = 10
            len = valid.length() / 2;
        } else {
            //j = 11
            len = valid.length() / 2 + 1;
        }
        
        for(int k = len; k < valid.length(); k++) {
            if(valid.charAt(k) == stack.pop()) {
                continue;
            } else {
                //System.out.println(k);
                //System.out.println(valid.charAt(k));
                //System.out.println(stack.peek());
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}