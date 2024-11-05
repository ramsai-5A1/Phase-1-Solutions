class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode previousNode = null;
        
        while (currNode != null) {
            ListNode nextNodeAdress = currNode.next;
            currNode.next = previousNode;
            previousNode = currNode;
            currNode = nextNodeAdress;
        }
        return previousNode;
    }
}