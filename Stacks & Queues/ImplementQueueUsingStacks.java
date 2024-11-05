class MyQueue {
    Stack<Integer> stack1, stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }

    private void copyFromS1ToS2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public int pop() {
        if (stack2.size() > 0) {
            return stack2.pop();
        }
        copyFromS1ToS2();
        return !stack2.isEmpty() ? stack2.pop() : -1;
    }
    
    public int peek() {
        if (stack2.size() > 0) {
            return stack2.peek();
        }
        copyFromS1ToS2();
        return !stack2.isEmpty() ? stack2.peek() : -1;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */