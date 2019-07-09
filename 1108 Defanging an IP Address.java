class Solution {
    public String defangIPaddr(String address) {
        if(address.length() == 0) {
            return "";
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        
        return sb.toString();
    }
}