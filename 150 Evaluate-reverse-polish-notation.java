/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        if(tokens.length == 0) {return 0;}
        for(String token : tokens) {
            if(token.equals("+")) {
                res = stack.pop() + stack.pop();
                stack.push(res);
            } else if (token.equals("-")) {
                res = -(stack.pop() - stack.pop());
                stack.push(res);
            } else if(token.equals("*")) {
                res = stack.pop() * stack.pop();
                stack.push(res);
            } else if(token.equals("/")) {
                int first = stack.pop();
                res = stack.pop() / first;
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}

