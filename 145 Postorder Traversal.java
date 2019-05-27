/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        if(root == null) {return postorder;}
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        
        while(node != null || !stack.empty()) {
            if(node != null) {
                stack.push(node);
                postorder.add(node.val);
                node = node.right;
            } else {
                TreeNode tmp = stack.pop();
                node = tmp.left;
            }  
        }
        
        Collections.reverse(postorder);
        
        return postorder;
    }
}