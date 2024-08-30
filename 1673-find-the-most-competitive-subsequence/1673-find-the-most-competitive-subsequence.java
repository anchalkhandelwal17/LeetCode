class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n + k)
        int n = nums.length;
        int[] ans = new int[k];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            int val = nums[i];
            while(!st.isEmpty() && st.peek() > val && n-i+st.size() > k){
                st.pop();
            }
            st.push(val);
        }
        int i=k-1; 
        while(st.size() > k){
            st.pop();
        }
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
}