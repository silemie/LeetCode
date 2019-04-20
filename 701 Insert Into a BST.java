class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if(val < root.val){
            if(root.left == null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            } else {insertIntoBST(root.left, val);}
        } else { 
            if(root.right == null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
            } else {insertIntoBST(root.right, val);}
        }
        
        return root;
    }
}