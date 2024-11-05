



/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        if(head ==null){
            return null;
        }
        Node cur= head;
        
        while(--p>=0){
            cur=cur.next;
        }
        
        Node insert= new Node(x);
        insert.next= cur.next;
        cur.next=insert;
        insert.prev=cur;
        
        if(insert.next!=null){
            insert.next.prev=insert;
            
        }
        return head;
    }
}