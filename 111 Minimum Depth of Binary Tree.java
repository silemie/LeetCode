/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * First time solution 
 * slow
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return findMinDep(root);
    }
    
    private int findMinDep(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        if(node.left == null) {
            return findMinDep(node.right) + 1;
        }
        
        if(node.right == null) {
            return findMinDep(node.left) + 1;
        }
        
        return Math.min(findMinDep(node.left), findMinDep(node.right)) + 1;
    }
}