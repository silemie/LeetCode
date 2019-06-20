class TrieNode {
    public TrieNode[] children;
    public boolean isWord;
    public String word;
  
    public TrieNode() {
        children = new TrieNode[26];
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isWord = false;
    }
}

public class WordDictionary {
    
    TrieNode root = new TrieNode();

    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();}
            p = p.children[c - 'a'];
        }
        
        p.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return find(word, 0, root);
    }
    
    private boolean find(String word, int index, TrieNode root) {
        if(index == word.length()) {
            return root.isWord;
        }
        
        Character c = word.charAt(index);
        if (c == '.') {
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null) {
                    if(find(word, index + 1, root.children[i])) {
                        return true;
                    }
                }
            }
            return false;
            
        } else {
            if (root.children[c - 'a'] == null) {
                return false;
            } else {
                return find(word, index + 1, root.children[c - 'a']);
            }
        }
    }
}