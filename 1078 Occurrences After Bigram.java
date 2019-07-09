class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        
        if(text.length() == 0 || first.length() == 0 || second.length() == 0) {
            return new String[0];
        }
        
        String[] words = text.split(" ");
        for(int i = 2; i < words.length; i++) {
            if(words[i - 2].equals(first) && words[i - 1].equals(second)) {
                ans.add(words[i]);
            }
        }
        
        String[] res = new String[ans.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}