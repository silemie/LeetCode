class Solution {
    public String removeOuterParentheses(String S) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        int begin = 0;
        stack.push(S.charAt(begin));
        
        for(int i = 1; i < S.length(); i++) {
            if(stack.isEmpty() && S.charAt(i) == '(') {
                answer = answer + S.substring(begin + 1, i - 1);
                System.out.println(i);
                begin = i;
            }
            
            if (S.charAt(i) == '('){
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
            
        }
        
        answer = answer + S.substring(begin + 1, S.length() - 1);
        return answer;
    }
}

/**
 * Faster solutions
 */

class Solution {
    public String removeOuterParentheses(String S) {
        
        StringBuilder sb = new StringBuilder();
        int open=0, close=0, start=0;
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '(') {
                open++;
            } else if(S.charAt(i) == ')') {
                close++;
            }
            if(open==close) {
                sb.append(S.substring(start+1, i));
                start=i+1;
            }
        }
        return sb.toString();
    }
}