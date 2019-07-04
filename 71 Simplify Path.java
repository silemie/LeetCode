public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        
        if(path.length() == 0 || path == null) {
            return "";
        }
        // write your code here
        String ans = "/";
        String [] ops = path.split("/");
        List<String> paths = new ArrayList<>();
        
        for(String op : ops) {
            if(op.equals("..")) {
                if (paths.size() > 0 ) {
                    paths.remove(paths.size() - 1);
                }
            } else if(!op.equals(".") && !op.equals("")) {
                paths.add(op);
            }
        }
        
        for(String p : paths) {
            ans += p + "/";
        }
        
        if(ans.length() > 1) {
            return ans.substring(0, ans.length() - 1);
        }
        return ans;
    }
}