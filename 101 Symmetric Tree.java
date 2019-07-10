/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /* Recursive solution */
 /* recursive solution use more memory */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return isSymmetricHelper(root.left, root.right);
        }
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        
        if (left == null && right != null) {
            return false;
        }
        
        if (left != null && right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right, right.left);
    }
}

//Iterative Solution 
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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        if(root.left != null) {
            if(root.right == null) {
                return false;
            } else {
                stack.push(root.left);
                stack.push(root.right);
            }
        } else {
            if(root.right != null) {
                return false;
            }
        }
        
        while(stack.size() != 0) {
            int size = stack.size();
            if(size % 2 != 0) {
                return false;
            }
            
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if(right.val != left.val) {
                return false;
            }
            
            if(left.left != null) {
                if(right.right == null) {
                    return false;
                } else {
                    stack.push(left.left);
                    stack.push(right.right);
                }
            } else {
                if(right.right != null) {
                    return false;
                }
            }
            
            if(left.right != null) {
                if(right.left == null) {
                    return false;
                } else {
                    stack.push(left.right);
                    stack.push(right.left);
                }
            } else {
                if(right.left != null) {
                    return false;
                }
            }
        }
        
        return true;
    }