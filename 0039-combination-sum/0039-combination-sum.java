class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, new ArrayList<>(), ans, target);

        return ans;
    }

    public void solve(int i, int[] nums, List<Integer> list, List<List<Integer>> ans, int target){

        if(i < nums.length && target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(i >= nums.length || target < 0){
            return;
        }


        list.add(nums[i]);
        solve(i, nums, list, ans, target - nums[i]);
        list.remove(list.size()-1);
        solve(i+1, nums, list, ans, target);
    }
}