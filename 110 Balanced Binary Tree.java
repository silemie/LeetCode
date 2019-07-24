/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(Math.abs(left - right) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }
}

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return balanceHelper(root) != -1;
    }
    
    public int balanceHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = balanceHelper(root.left);
        int right = balanceHelper(root.right);
        
        if(left == -1 || right == -1) {
            return -1;
        }
        
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
         
    }
}