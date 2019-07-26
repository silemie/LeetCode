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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        int curMin = Integer.MAX_VALUE;
        boolean find = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(q.size() != 0) {
            TreeNode node = q.poll();
            if(node.val <= curMin && node.val > root.val) {
                find = true;
                curMin = node.val;
            }
            
            if(node.left != null) {
                q.offer(node.left);
            }
            
            if(node.right != null) {
                q.offer(node.right);
            }
        }
        
        if(!find) {
            return -1;
        }
        
        return curMin;
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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        return DFS(root, root.val);
    }
    
    private int DFS(TreeNode root, int min) {
        if(root == null) {
            return -1;
        }
        
        if(root.val > min) {
            return root.val;
        }
        
        int left = DFS(root.left, min);
        int right = DFS(root.right, min);
        
        if(left == -1) {
            return right;
        }
        
        if(right == -1) {
            return left;
        }
        
        return Math.min(left, right);
    }
}