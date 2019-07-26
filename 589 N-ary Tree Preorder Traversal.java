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
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer>  preorder = new ArrayList<>();
        if(root == null) {return preorder;}
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.empty()) {
            Node node = stack.pop();
            preorder.add(node.val);
            
            Collections.reverse(node.children);
            for(Node c : node.children) {
                stack.add(c);
            }
        }
        
        return preorder;
        
    }
}

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
class Solution {
    
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        
        
        
        preorderHelper(root, ans);
        
        return ans;
    }
    
    private void preorderHelper(Node root, List<Integer> ans) {
        
        if(root == null) {
            return;
        }
        
        ans.add(root.val);
        
        for(Node n : root.children) {
            preorderHelper(n, ans);
        }
    }
}