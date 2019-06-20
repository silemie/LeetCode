class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        word = null;
        children = new HashMap<Character, TrieNode>();
    }
}

class TrieTree {
    TrieNode root;
    
    public TrieTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        
        node.word = word;
    }
}

public class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> findWords(char[][] board, String[] words) {
        // write your code here
        List<String> results = new ArrayList<>();
        
        TrieTree tree = new TrieTree();
        
        for(String word : words) {
            tree.insert(word);
        }
        
        //两条线
        //一条DFS主线
        //一条是在树中到哪儿了
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }
        
        return results;
    }
    
    private void search(char[][] board, int x, int y, TrieNode node, List<String> results) {
        if(!node.children.containsKey(board[x][y])) {
            return ;
        }
        
        TrieNode child = node.children.get(board[x][y]);
        if(child.word != null) {
            if(!results.contains(child.word)) {
                results.add(child.word);
            }
        }
        
        char c = board[x][y];
        board[x][y] = 0;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(board, nx, ny)) {
                search(board, nx, ny, child, results);
            }
        }
        board[x][y] = c;
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 0);
    }
}