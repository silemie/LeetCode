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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        
        if(root1 == null || root2 == null) {
            return false;
        }
        
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        
        inorder(root1, leaf1);
        inorder(root2, leaf2);
        
        for(int i = 0; i < leaf1.size(); i++) {
            if(leaf1.get(i) != leaf2.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void inorder(TreeNode root, List<Integer> leaf) {
        if(root == null) {
            return ;
        }
        
        if(root.left == null && root.right == null) {
            leaf.add(root.val);
            return ;
        }
        
        inorder(root.left, leaf);
        inorder(root.right, leaf);
    }
    
    
}