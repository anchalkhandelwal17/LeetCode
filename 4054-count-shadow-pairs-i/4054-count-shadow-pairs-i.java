class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && st.peek() > nums[i]){
                if(map.containsKey(st.peek())){
                    map.remove(st.peek());
                }
                st.pop();
            }
            if(!st.isEmpty() && nums[i] > st.peek()){
                ans += st.size();
            }
            if(!st.isEmpty() && nums[i] == st.peek()){
                ans = ans + (st.size() - map.getOrDefault(st.peek(), 1));
            }
            st.push(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return ans;
    }
}