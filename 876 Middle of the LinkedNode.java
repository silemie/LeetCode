/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node.next != null) {
            count++;
            node = node.next;
        }
        
        int middle = 0;
        
        if(count % 2 == 0) {
            middle = count / 2;
        } else {
            middle = count / 2 + 1;
        }
        
        System.out.println(middle);
        
        ListNode ans = head;
        for(int i = 0; i < middle; i++) {
            ans = ans.next;
        }
        
        return ans;
    }
}