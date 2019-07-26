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
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        if(root == null) {
            return min;
        }
       
        minDiffInBST(root.left);
        if(prev != null) {
            if(Math.abs(root.val - prev.val) < min) {
                min = Math.abs(root.val - prev.val);
            }
        }
        
        prev = root;
        minDiffInBST(root.right);
        
        return min;
    }

}