/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return head;
        Node curr = head;
        // Node temp = new Node(-1);

        // INSERT A DUPLICATE LIST BETWEEN
        while(curr!=null){
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        curr = head;
        //Copy random pointers
        while(curr!=null)
        {
            if(curr.random!=null)
            curr.next.random = curr.random.next;
            curr=curr.next.next;
        }

        //Break connections
        curr = head;
        Node nextNode = curr.next;
        Node copy = nextNode;

        while(curr!=null){
            curr.next = curr.next.next;
            if(curr.next!=null){
                copy.next = copy.next.next;
                copy = copy.next;
            }

            curr = curr.next;
        }
        return nextNode;
    }
}
