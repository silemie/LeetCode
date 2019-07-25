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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return sumOfLeftLeaves(root, root, 0);
    }
    
    private int sumOfLeftLeaves(TreeNode root, TreeNode parent, int sum) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            if(root == parent.left) {
                sum += root.val;
            }
            
            return sum;
        }
        
        return sumOfLeftLeaves(root.left, root, sum) + sumOfLeftLeaves(root.right, root, sum);
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        Stack<TreeNode> parent = new Stack<>();
        parent.push(root);
        
        while(stack.size() != 0) {
            TreeNode node = stack.pop();
            TreeNode prev = parent.pop();
            
            if(node.left == null && node.right == null) {
                if(node == prev.left) {
                    sum += node.val;
                }
            }
            
            if(node.left != null) {
                stack.push(node.left);
                parent.push(node);
            }
            
            if(node.right != null) {
                stack.push(node.right);
                parent.push(node);
            }
        }
        
        return sum;
    }
}