class TrieNode {
  public TrieNode[] sons;
  public boolean isWord;
  public String word;
  
  public TrieNode() {
    sons = new TrieNode[26];
    for(int i = 0; i < 26; i++) {
      sons[i] = null;
    }
    
    isWord = false;
  }
}

public class Trie {
    TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(node.sons[c - 'a'] == null) {
                node.sons[c - 'a'] = new TrieNode();
            }
            
            node = node.sons[c - 'a'];
        }
        
        node.isWord = true;
        node.word = word;
        
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(node.sons[c - 'a'] == null) {
                return false;
            } else {
                node = node.sons[c - 'a'];
            }
        }
        
        if(node.isWord && node.word.equals(word)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if(node.sons[c - 'a'] == null) {
                return false;
            } else {
                node = node.sons[c - 'a'];
            }
        }
        
        return true;
    }
}