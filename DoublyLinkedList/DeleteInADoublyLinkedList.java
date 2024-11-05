class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
       if (head == null || x < 1) {
            return head;
        }

        // If the node to be deleted is the head node
        if (x == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // Traverse to the x-th node
        Node current = head;
        int count = 1;
        while (current != null && count < x) {
            current = current.next;
            count++;
        }

        // If the node to be deleted exists
        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }

        return head;
    }
}