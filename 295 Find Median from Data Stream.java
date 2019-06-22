class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap, maxHeap;
    //minHeap for large nums
    //maxHeap for small nums
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());     
    }
    
    //ensure that the size of minHeap = the size of maxHeap
    //Or the size of minHeap = the size of maxHeap + 1
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        balance();
        
    }
    
    private void balance() {
        if(minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        } 
        
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        double med;
        if((minHeap.size() + maxHeap.size()) % 2 == 0) {
            med = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            med = maxHeap.peek();
        }
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */