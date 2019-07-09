class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        
        int[][] ans = new int[A.length][A[0].length];
        int k = 0;
        for(int[] lines : A) {
            int[] newLine = new int[lines.length];
            for(int i = 0; i < lines.length; i++) {
                if(lines[i] == 0) {
                    newLine[lines.length - i - 1] = 1;
                } else {
                    newLine[lines.length - i - 1] = 0;
                }
            }
            
            ans[k++] = newLine;
        }
        
        return ans;
    }
}