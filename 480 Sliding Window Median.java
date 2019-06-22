public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    PriorityQueue<Integer> maxHeap, minHeap;
    public double[] medianSlidingWindow(int[] A, int k) {
        // write your code here
        List<Double> res = new ArrayList<Double>();
        int n = A.length;
        if (n == 0) {
            return new double[0];
        }
        
        maxHeap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(n);
        
        int i;
        for (i = 0; i < n; ++i) {
            if (maxHeap.size() == 0 || A[i] <= maxHeap.peek()) {
                maxHeap.offer(A[i]);
            }
            else {
                minHeap.offer(A[i]);
            }
            
            balance();
            if (i - k >= 0) {
                if (A[i - k] > maxHeap.peek()) {
                    minHeap.remove(A[i - k]);
                }
                else {
                    maxHeap.remove(A[i - k]);
                }
            }
            
            balance();
            
            if (i >= k - 1) {
                if(k % 2 == 0) {
                    
                    res.add(((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0);
                } else {                
                    res.add((double)maxHeap.peek());
                }
            }
        }
        
        double[] ans = new double[res.size()];
        for(i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
    
    private void balance() {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
}