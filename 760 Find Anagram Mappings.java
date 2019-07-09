class Solution {
    public int[] anagramMappings(int[] A, int[] B) {        
        Map<Integer, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
            hash.put(B[i], i);
        }
        
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            ans[i] = hash.get(A[i]);
        }
        
        return ans;
    }
}