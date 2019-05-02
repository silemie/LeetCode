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
  * Problem: too much memory
  */
class Solution {
    public int minDepth(TreeNode root) {
        
        if(root == null) {return 0;}
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        int depth = 0;
        while(q.size() != 0) {
            int size = q.size();
            depth += 1;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(node.left == null && node.right == null) {
                    return depth;
                }
                
                if(node.left != null) {
                   q.add(node.left); 
                }    
                
                if(node.right != null) {
                    q.add(node.right);
                }
                
                
            }
            
        }
        
        return depth;
    }
}