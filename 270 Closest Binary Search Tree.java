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
    public int closestValue(TreeNode root, double target) {
        
        if(root == null) {
            return 0;
        }
        
        int prev = root.val;
        TreeNode node = root;
        
        while(node != null) {
            if(Math.abs(target - node.val) < Math.abs(target - prev)) {
                prev = node.val;
            }
            
            if(node.val > target) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        return prev;
    }
}