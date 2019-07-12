class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> hash = new HashMap<>();
        List<Integer> record = new ArrayList<>();
        
        for(int n : nums1) {
            if(hash.containsKey(n)) {
                int count = hash.get(n);
                hash.put(n, count + 1);
            } else {
                hash.put(n, 1);
            }
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(hash.containsKey(nums2[i]) && hash.get(nums2[i]) > 0) {
                record.add(nums2[i]);
                hash.put(nums2[i], hash.get(nums2[i]) - 1);
            }
        }
        
        int[] ans = new int[record.size()];
        int index = 0;
        for(int num : record) {
            ans[index] = num;
            index++;
        }
        
        return ans;
    }
}