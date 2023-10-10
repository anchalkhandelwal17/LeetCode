class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int size = q1.size();
        while(size > 1){
            q2.add(q1.remove());
            size--;
        }
        int remove = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return remove;
    }
    
    public int top() {
         int size = q1.size();
        while(size > 1){
            q2.add(q1.remove());
            size--;
        }
        int x = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        q1.add(x);
        return x;
    }
    
    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */