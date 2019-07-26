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
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        
        StringBuilder ans = new StringBuilder();
        
        helper(t, ans);
        
        String tree = ans.toString();
        return tree.substring(1, tree.length() - 1);
    }
    
    private StringBuilder helper(TreeNode t, StringBuilder ans) {
        if(t == null) {
            return ans.append("");
        }
        
        ans.append("(");
        ans.append(t.val);
        
        if(t.right != null && t.left == null) {
            ans.append("()");
        }
        helper(t.left, ans);
        helper(t.right, ans);
        
        ans.append(")");
        
        return ans;
    }
}