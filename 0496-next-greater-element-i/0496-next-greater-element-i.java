class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--){
            int ele = nums2[i];

            while(!st.isEmpty() && st.peek() <= ele){
                st.pop();
            }
            int ng = st.isEmpty() ? -1 : st.peek();
            map.put(ele, ng);
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}