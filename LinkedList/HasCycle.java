/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)   return false;
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        } while(fast != null && slow != fast);
        return slow == fast;
    }
}