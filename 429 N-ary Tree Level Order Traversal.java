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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {return result;}
        
        q.add(root);
        
        while(q.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            int index = q.size();
            for(int i = 0; i < index; i++) {
                Node node = q.poll();
                level.add(node.val);
                for(Node c : node.children) {
                    q.add(c);
                }
            }
            result.add(level);
        }
        return result;
    }
}