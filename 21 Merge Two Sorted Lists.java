/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode node;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/*

class Solution {
    ListNode node;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                pre.next = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                pre.next = l1;
                l1 = l1.next;
            } else if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            
            pre = pre.next;
        }
        
        return preHead.next;
    }
}
*/
