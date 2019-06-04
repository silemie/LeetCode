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