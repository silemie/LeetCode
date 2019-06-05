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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preIdx, int inIdx, int inEnd) {
        
        if(inIdx > inEnd || preIdx > preorder.length - 1) {return null;}
        
        TreeNode root = new TreeNode(preorder[preIdx]);
        int index = 0;
        for(int i = inIdx; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                index = i;
            }
        }
        
        root.left = buildTreeHelper(preorder, inorder, preIdx + 1, inIdx, index - 1);
        root.right = buildTreeHelper(preorder, inorder, preIdx + index - inIdx + 1, index + 1, inEnd);
        
        return root;
    }
}