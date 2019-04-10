class Solution {
    /**
     *  Use an array to record char
     *  Time and space complexity is O(n)
     */
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[128];
        String [] tokens = s.split("");
        for (String token : tokens) {
            char c = token.charAt(0);
            int index = c;
            arr[index]++;
        }
        
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                count++;
                if(count > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

/**
 * Using HashSet
 * Faster than the array implementation
 * 
 * class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> charSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charSet.contains(c)){
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }
        
        return charSet.size() == 0 || charSet.size() == 1;
    }
}
 */

