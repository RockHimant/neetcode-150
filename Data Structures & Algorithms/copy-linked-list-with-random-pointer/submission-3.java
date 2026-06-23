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
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            Node dummy = new Node(curr.val);
            dummy.next = curr.next;
            curr.next = dummy;
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
            
            
        }

        curr = head;
        Node head2 = curr.next;
        Node ptr = head2;
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            if (curr != null) {
                ptr.next = curr.next;
                ptr = ptr.next;
            }    

        }

        return head2;
        
    }
}
