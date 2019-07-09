class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        
        for(int i = 0; i < A[0].length(); i++) {
            for(int k = 0; k < A.length; k++) {
                if(k < A.length - 1 && A[k].charAt(i) > A[k + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}