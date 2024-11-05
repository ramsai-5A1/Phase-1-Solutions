class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        DLLNode prev = null;
        DLLNode curr = head;
        while(curr!=null){
            DLLNode forw = curr.next;
            curr.next = prev;
            curr.prev = forw;
            prev = curr;
            curr = forw;
        }
        return prev;

    }
}