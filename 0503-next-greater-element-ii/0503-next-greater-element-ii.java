class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            st.push(i);
        }

        for(int i=n-1; i>=0; i--){
            ans[i] = -1;

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i] = nums[st.peek()];

            st.push(i);
        }
        return ans;
    }
}

// so firstly, how do you find the nge
// [1, 2, 3, 4, 3]
// st => [4, 3, 2, 1]
// [-1, -1, 4, 3, 2]

// st.peek() <= nums[i]
