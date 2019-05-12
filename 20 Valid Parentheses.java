class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.size() == 0) {return false;}
                char anotherC = stack.pop();
                if (c == ')' && anotherC !='(') {return false;}
                if (c == ']' && anotherC !='[') {return false;}
                if (c == '}' && anotherC !='{') {return false;}
            }
        }
        
        return (stack.size() == 0);
    }
}