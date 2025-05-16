class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums.length, nums, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int i, int n, int[] nums, List<List<Integer>> ans, List<Integer> list){
        if(i >= n){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(i+1, n, nums, ans, list);
        list.remove(list.size()-1);
        solve(i+1, n, nums, ans, list);
    }
}

// simple take not_take recursion