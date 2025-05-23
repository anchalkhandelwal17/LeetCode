class MinStack {
    Stack<int[]> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(new int[]{val, min});
    }
    
    public void pop() {
        int[] peek = st.pop();
        if(peek[1] == min){
            if(st.isEmpty()) min = Integer.MAX_VALUE;
            else min = st.peek()[1];
        }
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */