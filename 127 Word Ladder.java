class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> dict = new HashSet<>();
        
        for(String word : wordList) {
            dict.add(word);
        }
        
        if(!dict.contains(endWord)) {
            return 0;
        }
        
        if(beginWord.equals(endWord)) {
            return 1;
        }
        
        HashSet<String> hash = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        hash.add(beginWord);
        
        int steps = 1;
        while(q.size() != 0) {
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                for(String nextWord : getWord(word, dict)) {
                    if(hash.contains(nextWord)) {
                        continue;
                    }
                    
                    if(nextWord.equals(endWord)) {
                        return steps;
                    }
                    
                    hash.add(nextWord);
                    q.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getWord(String word, HashSet<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < word.length(); i++) {
                if(c == word.charAt(i)) {
                    continue;
                }
                
                String nextWord = replace(word, i, c);
                if(dict.contains(nextWord)) {
                    list.add(nextWord);
                }
            }
        }
        
        return list;
    }
    
    private String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        
        return new String(chars);
    }

}