class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int i, int[] nums, List<List<Integer>> ans, List<Integer> list){
        if(i >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(i+1, nums, ans, list);
        list.remove(list.size()-1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        solve(i+1, nums, ans, list);
    }
}