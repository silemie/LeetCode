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
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        for(int i = 0; i < k - 1; i ++) {
            TreeNode node = stack.peek();
            
            if(node.right == null) {
                node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                
                node = node.right;
                
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return stack.peek().val;
    }
}