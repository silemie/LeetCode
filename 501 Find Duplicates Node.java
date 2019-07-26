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
    public int[] findMode(TreeNode root) {
        if(root == null) {
            return new int [0];
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        inorder(root, list);
        
        int[] ans = new int[list.size()];
        
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    private int count = 1;
    private int maxCount = 0;
    private TreeNode prev = null;
    
    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        
        inorder(root.left, list);
        
        if(prev != null) {
            if(prev.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if(count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if(count == maxCount) {
            list.add(root.val);
        }
        
        prev = root;
        
        inorder(root.right, list);
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
    public int[] findMode(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        
        inorder(root);
        modes = new int[modeCount];
        curCount = 0;
        modeCount = 0;
        inorder(root);
        
        return modes;
    }
    
    int[] modes;
    int curCount = 0;
    int modeCount = 0;
    int maxCount = 0;
    int prev = -1;
    
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inorder(root.left);
        
        if(prev != root.val) {
            prev = root.val;
            curCount = 0;
        }
        
        curCount++;
        
        if (curCount > maxCount) {
            maxCount = curCount;
            modeCount = 1;
        } else if(curCount == maxCount) {
            if(modes != null) {
                modes[modeCount] = prev;
            }
            modeCount++;
        }
        
        inorder(root.right);
    }
}