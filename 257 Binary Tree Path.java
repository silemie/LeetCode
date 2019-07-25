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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        
        if(root == null) {
            return ans;
        }
        
        String path = "";
        
        return treePathHelper(root, path, ans);
    }
    
    private List<String> treePathHelper(TreeNode root, String path, List<String> ans) {
        if(root == null) {
            return ans;
        }
        
        path += "->";
        path += Integer.toString(root.val);
        
        if(root.left == null && root.right == null) {
            ans.add(path.substring(2,path.length()));
        }
        
        treePathHelper(root.left, path, ans);
        treePathHelper(root.right, path, ans);
        
        return ans;
    }
}