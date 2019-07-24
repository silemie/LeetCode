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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        if(q.val < p.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        return root;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        if(q.val < p.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        while(root != null) {
            if(root.val <= q.val && root.val >= p.val) {
                return root;
            }
            
            if(root.val < p.val) {
                root = root.right;
            }
            
            if(root.val > q.val) {
                root = root.left;
            }
        }
        
        return root;
    }
}