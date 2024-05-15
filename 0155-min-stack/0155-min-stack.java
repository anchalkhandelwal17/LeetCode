class MinStack {
    // TC : O(1)
    // SC : O(n + n)
    Stack<int[]> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(new int[]{val, min});
    }
    
    public void pop() {
        int[] val = st.pop();
        if(val[1] == min){
            min = st.isEmpty() ? Integer.MAX_VALUE : st.peek()[1];
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