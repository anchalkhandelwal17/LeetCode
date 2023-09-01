class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }


    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] flag){
        // base condition
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        else{
             // generate all the possible unique permutations
            for(int i=0; i<nums.length; i++){
                if(flag[i]){
                    continue;
                }
                if(i > 0 && nums[i] == nums[i-1] && !flag[i-1]) continue;
                flag[i] = true;
                temp.add(nums[i]);
                helper(nums, temp, ans, flag);
                temp.remove(temp.size()-1);
                flag[i] = false;
            }
        }
    }
}