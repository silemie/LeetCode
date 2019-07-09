// public class Solution {
//     public String findContestMatch(int n) {
//         String[] matches = new String[n];
        
//         for(int i = 0; i < n; i++) {
//             matches[i] = Integer.toString(i + 1);
//         }
        
//         while(n > 1) {
//             for (int i = 0; i < n/2; i++) {
//                 matches[i] = "(" + matches[i] + "," + matches[n - i - 1] + ")";
//             }
            
//             n = n/2;
//         }
        
//         return matches[0];
//     }
// }

class Solution {
    public String findContestMatch(int n) {
        if(n == 0) {
            return "";
        }
        String[] match = new String[n];
        for(int i = 0; i < match.length; i++) {
            match[i] = Integer.toString(i + 1);
        }
        
        while(n > 1) {
            for(int i = 0; i < n/2; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(match[i]);
                sb.append(",");
                sb.append(match[n - i - 1]);
                sb.append(")");
                match[i] = sb.toString();
            }
            
            n = n/2;
        }
        
        return match[0];
    }
}