class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] sol = new int[A.length];
        
        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(B[j] == A[i]) {
                    sol[i] = j;
                    break;
                } 
            }
        }
        
        return sol;
    }
}