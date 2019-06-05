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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int postIdx, int postEnd, int inIdx, int inEnd) {
        if(inIdx > inEnd || postIdx > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for(int i = inIdx; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                index = i;
            }
        }
        
        root.left = buildTreeHelper(inorder, postorder, postIdx, postIdx + index - inIdx- 1 , inIdx, index - 1);
        root.right = buildTreeHelper(inorder, postorder, postIdx + index - inIdx, postEnd - 1, index + 1, inEnd);
        
        return root;
        
    }
}