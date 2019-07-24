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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(sum);
        
        while(stack.size() != 0) {
            TreeNode node = stack.pop();
            int val = sumStack.pop();
            
            if(node.left == null && node.right == null) {
                if(val == node.val) {
                    return true;
                }
            }
            
            val -= node.val;
            
            if(node.right != null) {
                stack.push(node.right);
                sumStack.push(val);
            }
            
            if(node.left != null) {
                stack.push(node.left);
                sumStack.push(val);
            }
            
        }
        
        return false;
    }
}