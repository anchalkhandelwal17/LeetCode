class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // TC : O(n)
        // SC : O(n)
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int val = temperatures[i];

            while(!st.isEmpty() && st.peek()[0] <= val){
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek()[1] - i;
            st.push(new int[]{val, i});
        }
        return ans;
    }
}