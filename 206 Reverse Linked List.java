/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseHelper(head, null);
    }
    
    private ListNode reverseHelper(ListNode head, ListNode newNode) {
        if(head == null) {
            return newNode;
        }
        
        ListNode next = head.next;
        head.next = newNode;
        
        return reverseHelper(next, head);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode node = null;
        
//         while(head != null) {
//             ListNode next = head.next;
            
//             head.next = node;
//             node = head;
//             head = next;   
//         }
        
//         return node;
//     }
// }