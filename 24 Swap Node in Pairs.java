/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        head = swap(head, head.next);
        head.next.next = swapPairs(head.next.next);
        
        return head;
    }
    
    private ListNode swap(ListNode head, ListNode next) {
        ListNode tmp = next;
        head.next = tmp.next;
        tmp.next = head;
        head = tmp;
        
        return head;
    }
}