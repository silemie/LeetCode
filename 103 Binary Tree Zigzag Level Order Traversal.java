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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) {return zigzag;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        
        while(queue.size() != 0) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if(flag) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                
                if(node.right != null) {queue.add(node.right);}
                if(node.left != null) {queue.add(node.left);}
            }
            
            zigzag.add(level);
            if(flag) {
                flag = false;
            } else {
                flag = true;
            }
            
        }
        
        return zigzag;
    }
}