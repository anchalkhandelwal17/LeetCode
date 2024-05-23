class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        // TC : O(2^n * n)
        // SC : O(2^n * n)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<Integer>(), ans, k);
        return ans.size();
    }

    public void solve(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans
    , int k) {
        if (idx == nums.length) {
            if(list.size() > 0){
                 ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(!(list.contains(nums[idx] - k))){
            list.add(nums[idx]);
            solve(idx + 1, nums, list, ans, k);
            list.remove(list.size() - 1);
        }
        solve(idx + 1, nums, list, ans, k);
    }
}