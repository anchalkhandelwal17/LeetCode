class Solution {
    public int[] finalPrices(int[] prices) {
        // TC : O(n)
        // SC : O(n)
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int val = prices[i];

            while(!st.isEmpty() && val < st.peek()){
                st.pop();
            }

            ans[i] = st.isEmpty() ? val : val - st.peek();
            st.push(val);
        }
        return ans;
    }
}