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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {return false;}
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int depth = 0;
        int xdepth = 0;
        int ydepth = 0;
        
        q.add(root);
        
        while(q.size() != 0) {
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++) { 
                TreeNode node = q.poll();
                
                if(node.left != null) {
                    q.add(node.left);
                    if(node.left.val == x) {
                        xdepth = depth + 1;
                        if(node.right != null && node.right.val == y) {return false;}
                    }
                    if(node.left.val == y) {
                        ydepth = depth + 1;
                        if(node.right != null && node.right.val == x) {return false;}
                    }
                }
                
                if(node.right != null) {
                    q.add(node.right);
                    if(node.right.val == x) {
                        xdepth = depth + 1;
                        if(node.left != null && node.left.val == y) {return false;}
                    }
                    if(node.right.val == y) {
                        ydepth = depth + 1;
                        if(node.left != null && node.left.val == x) {return false;}
                    }
                }
                
            }
        }
        
        return xdepth == ydepth;
    }
}