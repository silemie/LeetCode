/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * 1 ms 
 * 50.7MB - recursive takes much space
 */
class Solution {
    public int maxDepth(Node root) {
        if(root == null) {return 0;}
        
        int maxDepth = 0;
        
        for(Node c : root.children) {
            int curDepth = maxDepth(c);
            if(curDepth > maxDepth) {
                maxDepth = curDepth;
            }
        }
        
        return maxDepth + 1;
    }
}

/**
 * 2 ms 
 * 43MB use less memory
 */
class Solution {
    public int maxDepth(Node root) {
        if(root == null) {return 0;}
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        int depth = 0;
        
        while(q.size() != 0) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                Node n = q.poll();
                for(Node c : n.children) {
                    q.add(c);
                }
            }
            
            depth += 1;
        }
        
        return depth;
    }
}