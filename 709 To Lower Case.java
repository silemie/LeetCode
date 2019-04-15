class Solution {
    public String toLowerCase(String str) {
        
        char [] s = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            s[i] = Character.toLowerCase(str.charAt(i));
        }
        
        String string = new String(s);
    
        return string;
    }
}