/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
     
    //How to devide and conquer?
    //A stringbuffer,do DFS
    
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        
        ans = new ArrayList<String>();
        if(root == null) {
            return ans;
        }
        
        pathHelper(root, "");
        
        return ans;
    }
    
    private String pathHelper(TreeNode root, String prev) {
        
        if(root == null) {
            return "";
        }
        
        int value = root.val;
        prev = prev + Integer.toString(value) + "->";
        
        
        String left = pathHelper(root.left, prev);
        String right = pathHelper(root.right, prev);
        
        if(left == "" && right == "") {
            String s = prev.substring(0, prev.length() - 2);
            ans.add(s);
        }
        
        return prev;
    }
    
    
    
}