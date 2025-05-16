class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums.length, nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    public void solve(int n, int[] nums, List<List<Integer>> ans,
            List<Integer> list, boolean[] vis) {
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            list.add(nums[i]);
            solve(n, nums, ans, list, vis);
            vis[i] = false;
            list.remove(list.size()-1);
        }
    }
}
