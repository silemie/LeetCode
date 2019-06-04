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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        if(root == null) {return postorder;}
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        
        while(!stack.empty() || node != null) {
            
            while(node != null) {
                if(node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                node = node.left;
            }
            
            TreeNode visitedNode = stack.pop();  
            
            TreeNode right;
            if(stack.size() != 0) {
                right = stack.peek();
            } else {
                right = null;
            }
            
            if(visitedNode.right != null && visitedNode.right == right) {
                node = stack.pop();
                stack.push(visitedNode);
            } else {
                postorder.add(visitedNode.val);
                System.out.println(stack.size());
                node = null;
            }
            
        }
        
        return postorder;
        
    }
}

//Reverse of preorder

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
    /* Left - Right - Root */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if(root == null) {return postorder;}
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            postorder.add(node.val);
            
            if(node.left != null) {
                stack.add(node.left);
            }
            
            if(node.right != null) {
                stack.add(node.right);
            }
        }
        
        Collections.reverse(postorder);
        
        return postorder;
    }
}