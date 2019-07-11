class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        
        for(int n : nums1) {
            set.add(n);
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }
        
        int[] res = new int[ans.size()];
        int index = 0;
        for(int n : ans) {
            res[index] = n;
            index++;
        }
        
        return res;
    }
}