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
    public List<Integer> postorder(Node root) {
        List<Integer> postorder = new ArrayList<>();
        if(root == null) {return postorder;}
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.empty()) {
            Node node = stack.pop();
            postorder.add(node.val);
            
            for(Node c : node.children) {
                stack.add(c);
            }
        }
        
        Collections.reverse(postorder);
        
        return postorder;
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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null) {
            return ans;
        }
        
        Stack<Node> stack = new Stack<>(); 
        Stack<Node> post = new Stack<>();
        stack.push(root);
        
        while(stack.size() != 0) {
            Node node = stack.pop();
            post.push(node);
            for(Node n : node.children) {
                stack.push(n);
            }
        }
        
        while(post.size() != 0) {
            Node cur = post.pop();
            ans.add(cur.val);
        }
        
        return ans;
    }
}