/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.57%)
 * Likes:    4458
 * Dislikes: 618
 * Total Accepted:    451.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int k=(m+n)/2;
        int i=0, j=k;
        int lo=0, hi=Math.min(k,m);
        
        while (true) {
            i=lo+(hi-lo)/2;
            j=k-i;
            if (get(nums1,i)>=get(nums2,j-1)) {
                if (get(nums2,j)>=get(nums1,i-1)) break;
                else hi=i-1;
            }
            else lo=i+1;
        }
        if ((m+n)%2==1) return Math.min(get(nums1,i),get(nums2,j)); //odd
        return (double)(Math.min(get(nums1,i),get(nums2,j))+Math.max(get(nums1,i-1),get(nums2,j-1)))/2;//even
    }
    private int get(int[] nums, int i) {
        if (i<0) return Integer.MIN_VALUE;
        if (i>=nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}

