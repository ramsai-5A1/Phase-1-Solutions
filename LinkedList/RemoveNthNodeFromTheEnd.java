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
        ListNode curr = head;
        while(n-- > 0) {
            curr = curr.next;
        }
        ListNode prev = null, delNode = head;
        while (curr != null) {
            curr = curr.next;
            prev = delNode;
            delNode = delNode.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = delNode.next;
        }
        return head;
    }
}