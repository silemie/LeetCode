class Solution {
    public int search(ArrayReader reader, int target) {
        int k = 0;
        while(reader.get(k) <= target) {
            k = k * 2 + 1;
        }
        
        int left = 0;
        int right = k;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(reader.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            } 
        }
        
        if(reader.get(left) == target) {
            return left;
        } else {
            return -1;
        }
    }
}