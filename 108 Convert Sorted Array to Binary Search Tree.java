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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        
        return generateHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode generateHelper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = start + (end - start + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = generateHelper(nums, start, mid - 1);
        node.right = generateHelper(nums, mid + 1, end);
        
        return node;
    }
}