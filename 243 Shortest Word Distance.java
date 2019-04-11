class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDist = words.length;
        int currDist;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
            } else if(words[i].equals(word2)) {
                index2 = i;
            }
            
            if(index1 >= 0 && index2 >= 0) {
                currDist = Math.abs(index1 - index2);
                minDist = Math.min(minDist, currDist);
            }
        }
        
        return minDist;
    }
}