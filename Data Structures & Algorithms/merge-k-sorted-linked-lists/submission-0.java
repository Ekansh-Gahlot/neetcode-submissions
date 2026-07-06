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
    public ListNode mergeKLists(ListNode[] list) {
        int K = list.length;
        ListNode head = null;
        ListNode curr = null;
        // System.out.println(k);

        while(true){
            int a = 0;
            int z = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < K; i++)
            {
                if(list[i]!=null){
                    a++;
                    if(list[i].val<min){
                        min = list[i].val;
                        z = i;
                    }

                }
            }
            if(a!=0){
                list[z] = list[z].next;
                ListNode temp = new ListNode(min);
                if(head == null){
                    head = temp;
                    curr = temp;
                }else{
                    curr.next = temp;
                    curr = temp; 
                }
            }
            else{
                return head;
            }
        }
        // return -1;
    }
}
