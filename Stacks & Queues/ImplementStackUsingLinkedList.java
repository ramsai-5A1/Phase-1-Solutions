

class MyStack {
    // Define StackNode as an inner class
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    StackNode top; // Points to the top of the stack

    // Function to push an integer into the stack.
    void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.next = top; // Link the new node to the previous top
        top = newNode; // Update the top to the new node
    }

    // Function to remove an item from the top of the stack.
    int pop() {
        if (top == null) {
            return -1; // Stack is empty, return -1
        }
        int result = top.data; // Store the top data to return later
        top = top.next; // Move top to the next node
        return result;
    }
}