class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // TC : O(n + n)
        // SC : O(n + n)
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int val = temperatures[i];
            while(!st.isEmpty() && st.peek()[1] <= val){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = 0;
            else ans[i] = st.peek()[0] - i;

            st.push(new int[]{i, temperatures[i]});
        }
        return ans;
    }
}

// we can apply brute force to solve but that will be quadratic time coomplexity
// to solve it in a better time complexity , stack can we be used