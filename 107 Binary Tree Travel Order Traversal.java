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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(q.size() != 0) {
            int size = q.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                
                if(node.left != null) {
                    q.add(node.left);
                }
                
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            
            result.add(level);
        }
        
        List<List<Integer>> reverse = new ArrayList<List<Integer>>();
        
        for(int j = 0; j < result.size(); j++) {
            List<Integer> list = result.get(result.size() - j - 1);
            reverse.add(list);
        }
        
        return reverse;
    }
}