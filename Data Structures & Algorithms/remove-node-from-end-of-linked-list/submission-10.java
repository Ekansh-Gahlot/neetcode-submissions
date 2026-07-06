/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        if(n == 1 && head.next == null) return head.next;
        
        for(int i = 0; i < n; i++)
        {
            fast = fast.next;
        }
        
        // if (fast.next == null) return slow;
        if(fast == null) return slow.next;

        while(fast.next!=null)
        {
            System.out.println("HELLO");
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;

        return head;
    }
}
