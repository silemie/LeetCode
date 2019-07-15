class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
        if(arr.length == 0 || k == 0) {
            return ans;
        }
        
        int index = doBS(arr, x);
        int left = index;
        int right = index + 1;
        
        for(int i = 0; i < k; i++) {
            if(left < 0) {
                ans.add(arr[right]);
                right++;
            } else if(right > arr.length - 1) {
                ans.add(arr[left]);
                left--;
            } else {
                if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    ans.add(arr[left]);
                    left--;
                } else {
                    ans.add(arr[right]);
                    right++;
                }
            }
            
            Collections.sort(ans);
        }
        
        return ans;
    }
    
    private int doBS(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < x) {
                left = mid;
            } else if(nums[mid] > x) {
                right = mid;
            } else {
                return mid;
            }
        }
        
        if(nums[right] < x) {
            return right;
        } else {
            return left;
        }
    }
}