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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPre = dummy;

        while(true) {
            ListNode kth = getKth(groupPre, k);
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            ListNode pre = kth.next;
            ListNode curr = groupPre.next;

            while( curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }

            ListNode temp = groupPre.next;
            groupPre.next = kth;
            groupPre = temp;
        }

        return dummy.next;
       
    }

    public ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
