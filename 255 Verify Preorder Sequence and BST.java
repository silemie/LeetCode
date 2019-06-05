class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
        
    }
    
    private boolean helper(int[] preorder, int start, int end) {
        if(start >= end) {return true;}
        if(start == end - 1) {return true;}
        
        int root = preorder[start];
        int index = 0;
        for(int i = start; i <= end; i++) {
            if(preorder[i] > root) {
                index = i;
                break;
            }
        }
       
        if(index > 0) {
            for(int j = index; j <= end; j++) {
                if(preorder[j] < root) {
                    return false;
                }
            }
            
            return helper(preorder, start + 1, index - 1) && helper(preorder, index, end);
        } else {return helper(preorder, start + 1, end);}

        
    }
}

class Solution {
    public boolean verifyPreorder(int[] preorder) {
            int low = Integer.MIN_VALUE;
            Stack<Integer> stack = new Stack<>();
        
            for(int p : preorder) {
                if(p < low) {
                    return false;
                }
                
                while(!stack.empty() && p > stack.peek()) {
                    low = stack.pop();
                }
                
                stack.push(p);
            }
        
        return true;
        }
    }