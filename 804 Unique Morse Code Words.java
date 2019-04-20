class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> stringHash = new HashSet<String>();
        
        for(String word : words) {
            String encode = "";
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 97;
                encode = encode + morse[index];
            }
            stringHash.add(encode);
        }
        
        return stringHash.size();
    }
}