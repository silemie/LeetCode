class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        
        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < i + 1; j++) {
                G[i] += G[i - j] * G[j - 1];
            }
        }
        
        return G[n];
    }
}