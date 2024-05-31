class Solution {
    public int[] singleNumber(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else set.add(nums[i]);
        }

        for(int x : set) ans[idx++] = x;
        return ans;
    }
}