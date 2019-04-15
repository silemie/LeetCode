class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(intSet.contains(nums[i])) {
                return true;
            } else {
               intSet.add(nums[i]);
            }

        }
        
        return false;
    }
}

/**
 * A clever way!
 * class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!intSet.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}
 */

/**
 * class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            intSet.add(nums[i]);
        }
        
        return (intSet.size() != nums.length);
    }
}
 */