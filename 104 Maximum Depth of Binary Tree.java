/**
 * Definition for a binary tree node
 * 
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 * 
 *      TreeNode(int x) {val = x};
 * }
 */

 class Solution {
     public int maxDepth(TreeNode root)
     {
         if(root == null)
         {
             return 0;
         } else {
             return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
         }
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
    public int maxDepth(TreeNode root) {
        if(root == null) {return 0;}
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int depth = 0;
        while(q.size() != 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(node.left != null) {
                    q.add(node.left);
                } 
                
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            
            depth++;
            
        }
        
        return depth;
    }
}