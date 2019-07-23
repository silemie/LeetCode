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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<TreeNode>();
        }
        
        return generateHelper(1, n);
    }
    
    private LinkedList<TreeNode> generateHelper(int start, int end) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        if(start > end) {
            ans.add(null);
            return ans;
        }
        
        for(int i = start; i < end + 1; i++) {
            LinkedList<TreeNode> left = generateHelper(start, i - 1);
            LinkedList<TreeNode> right = generateHelper(i + 1, end);
            
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    ans.add(cur);
                }
            }
        }
        
        return ans;
    }
}