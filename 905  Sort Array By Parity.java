class Solution {
    public int[] sortArrayByParity(int[] A) {
        for(int i = 0, j = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                swap(A, i, j);
                j++;
            }
        }
        return A;
    }
    
    public void swap(int[] A, int k, int i) {
        int tmp = A[i];
        A[i] = A[k];
        A[k] = tmp;
    }
}