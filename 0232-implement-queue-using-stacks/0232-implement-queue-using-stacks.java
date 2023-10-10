class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queue;

    public MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(queue.isEmpty()){
            transfer();
        }
         return queue.pop();
    }
    
    public int peek() {
        if(queue.isEmpty() && !stack.isEmpty()){
            transfer();
        } return !queue.isEmpty() ? queue.peek() : -1;
    }
    
    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
    }

    public void transfer(){
        while(!stack.isEmpty()){
            queue.push(stack.pop());
        }
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