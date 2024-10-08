class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // TC : O(2^n * n)
        // SC : O(2^n * n) + recursion space
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int i, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(i >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(i+1, nums, list, ans);
        list.remove(list.size()-1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        solve(i+1, nums, list, ans);
    }
}