class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> hashset = new HashSet<Integer>();
        
        for(int i = 0; i < A.length; i++) {
            if(!hashset.add(A[i])) {return A[i];}
        }
        
        return 0;
    }
}