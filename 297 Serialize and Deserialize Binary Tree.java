/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) {
            return "[]";
        }
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        
        for(int i = 0; i < q.size(); i++) {
            TreeNode node = q.get(i);
            if(node == null) {
                continue;
            }
            
            q.add(node.left);
            q.add(node.right);
        }
        
        while(q.get(q.size() - 1) == null) {
            q.remove(q.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val);
        for(int i = 1; i < q.size(); i++) {
            if(q.get(i) == null) {
                sb.append(",null");
            } else {
                sb.append(",");
                sb.append(q.get(i).val);
            }
        }
        
        sb.append("]");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("[]")) {
            return null;
        }
        
        String[] elements = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        
        int index = 0;
        boolean isLeft = true;
        for(int i = 1; i < elements.length; i++) {
            if(!elements[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(elements[i]));
                if(isLeft) {
                    q.get(index).left = node;
                } else {
                    q.get(index).right = node;
                }
                
                q.add(node);
            }
            
            if(!isLeft) {
                    index++;
            }
            
            isLeft = !isLeft;
        }
        
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));