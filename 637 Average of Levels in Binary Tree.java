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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        if(root == null) {return avg;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() != 0) {
            int size = queue.size();
            Double sum = 0.0;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum += node.val;
                
                if(node.left != null) {queue.add(node.left);}
                if(node.right != null) {queue.add(node.right);}
            }
            
            avg.add(sum/size);
        }
        
        return avg;
    }
}