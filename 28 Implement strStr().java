public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
     
    public int base = 1000000;
    
    //Rabin Karp Algorithm
    //O(n+m)
    public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null) {
            return -1;
        }
        
        if(target.length() == 0) {
            return 0;
        }
        
        //a*31^length 
        
        int power = 1;
        for(int i = 0; i < target.length(); i++) {
            power = (power * 31) % base;
            //avoid exceeding limit
        }
        
        int targetCode = 0;
        for(int i = 0; i < target.length(); i++) {
            targetCode = (targetCode*31 + target.charAt(i)) % base;
        }
        
        int hashCode = 0;
        for(int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % base;
            if(i < target.length() - 1) {
                continue;
            }
            
            if(i > target.length() - 1) {
                hashCode = hashCode - (source.charAt(i - target.length()) * power) % base;
                if(hashCode < 0) {
                    hashCode += base;
                }
            }
            
            if(hashCode == targetCode) {
                if(source.substring(i - target.length() + 1, i + 1).equals(target)){
                    return i - target.length() + 1;
                }
            }
        }
        
        return -1;
    }
}