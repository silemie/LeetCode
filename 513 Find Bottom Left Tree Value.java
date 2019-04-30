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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) {return 0;}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int result = root.val;
        while(q.size() != 0) {
            TreeNode node = q.poll();
            
            if(node.right != null) {
                q.add(node.right);
                if(node.left == null) {
                    result = node.right.val;
                }
            }
            
            if(node.left != null) {
                q.add(node.left);
                result = node.left.val;
            }
            
        }
        
        return result;
        
    }
}