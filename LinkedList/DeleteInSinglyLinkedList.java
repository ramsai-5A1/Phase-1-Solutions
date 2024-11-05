

/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        if(x==1){
            head=head.next;
            return head;
        }
        int len=getsize(head);
        if(x==len){
            removelast(head);
            return head;
        }
        Node temp=head;
        int i=0;
        while(i<x-2){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;
    }
    int getsize(Node head){
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    void removelast(Node head){
        int i=0;
        int len=getsize(head);
        Node temp=head;
        while(i<len-2){
            temp=temp.next;
            i++;
        }
        int no=temp.next.data;
        temp.next=null;
    
    }
}