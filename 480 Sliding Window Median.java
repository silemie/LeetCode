public class Solution {

    PriorityQueue<Integer> maxHeap, minHeap;
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length == 0 || k == 0) {return ans;}
        
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        
        int index = 0;

        for(int i = 0; i < nums.length; i++) {
            if(minHeap.size() + maxHeap.size() < k) {
                if(maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
                    maxHeap.offer(nums[i]);
                } else {
                    minHeap.offer(nums[i]);
                }
                
                balance();
            }
            
            if(minHeap.size() + maxHeap.size() == k) {
                int med = maxHeap.peek();
                ans.add(med);
                if(nums[index] <= med) {
                    maxHeap.remove(nums[index]);
                } else {
                    minHeap.remove(nums[index]);
                }
                index++;
                balance();
            }
        }
        
        return ans;
    }
    
    private void balance() {
        if(minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
        
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
/*
public class Solution {

    PriorityQueue<Integer> maxHeap, minHeap;
    public List<Integer> medianSlidingWindow(int[] A, int k) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        if (n == 0) {
            return res;
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
                res.add(maxHeap.peek());
            }
        }
        
        return res;
    }
    
    private void balance() {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
}*/