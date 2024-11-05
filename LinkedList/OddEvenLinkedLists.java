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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddHead = head, oddTail = head;
        ListNode evenHead = head.next, evenTail = head.next;
        ListNode currNode = head.next.next;
        boolean isOdd = true;

        while (currNode != null) {
            if (isOdd) {
                oddTail.next = currNode;
                oddTail = oddTail.next;
            } else {
                evenTail.next = currNode;
                evenTail = evenTail.next;
            }
            currNode = currNode.next;
            isOdd = !isOdd;
        }
        oddTail.next = null;
        evenTail.next = null;

        // while (evenHead != null) {
        //     System.out.println(evenHead.val);
        //     evenHead = evenHead.next;
        // }
        oddTail.next = evenHead;
        return oddHead;
    }
}