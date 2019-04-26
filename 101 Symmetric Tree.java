/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /* Recursive solution */
 /* recursive solution use more memory */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return isSymmetricHelper(root.left, root.right);
        }
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        
        if (left == null && right != null) {
            return false;
        }
        
        if (left != null && right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right, right.left);
    }
}