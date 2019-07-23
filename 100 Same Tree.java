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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {return true;}
        else if(p == null && q != null) {return false;}
        else if(p != null && q == null) {return false;}
        
        Stack<TreeNode> t1 = new Stack<TreeNode>();
        Stack<TreeNode> t2 = new Stack<TreeNode>();
        
        t1.push(p);
        t2.push(q);
        
        while(!t1.empty() || !t2.empty()) {
            TreeNode left = t1.pop();
            TreeNode right = t2.pop();
            
            if(left.val != right.val) {return false;}
            
            if(left.left != null && right.left != null) {
                t1.push(left.left);
                t2.push(right.left);
            } else if(left.left == null && right.left == null) {
                
            } else {return false;}
            
            if(left.right != null && right.right != null) {
                t1.push(left.right);
                t2.push(right.right);
            } else if (left.right == null && right.right == null) {
                
            }else {return false;}
        }
        
        return true;
        
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p == null || q == null) {
            return false;
        } 
        
        if(p.val != q. val) {
            return false;
        } 
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}