// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    static Node segregate(Node head) {
        Node zero = null;
        Node one = null;
        Node two = null;
        
        Node temp = head;
        
        Node oneHead = null;
        Node twoHead = null;
        
        while(temp!=null){
            if(temp.data == 0){
                if(zero == null){
                    zero = temp;
                    head = zero;
                }else{
                    zero.next = temp;
                    zero = zero.next;
                }
            }else if(temp.data == 1){
                if(one == null){
                    one = temp;
                    oneHead = one;
                }else{
                    one.next = temp;
                    one = one.next;
                }
            }else{
                if(two == null){
                    two = temp;
                    twoHead = two;
                }else{
                    two.next = temp;
                    two = two.next;
                }
            }
            
            temp = temp.next;
        }
        
        if(zero!=null){
            if(one!=null){
                zero.next = oneHead;
                one.next = twoHead;
            }else{
                zero.next = twoHead;
            }
        }else{
            if(one!=null){
                head = oneHead;
                one.next = twoHead;
            }else{
                head = twoHead;
            }
        }
        
        if(two!=null){
            two.next = null;
        }
        
        return head;
    }
}