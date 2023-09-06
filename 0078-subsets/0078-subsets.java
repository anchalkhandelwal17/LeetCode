class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // TC : O( n * 2 ^ n) - beacuse we are copying the list of size n in base case
        // SC : O(n * 2 ^ n) // because we are generating the subsets which will be equal to 2 ^ n and extra n for generating and storing a particuar subset
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[] nums, int i, List<Integer> temp , List<List<Integer>> ans){
        if(i == nums.length){ // if i becomes == nums.length , add the temp as a new list in ans list of lists
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(nums, i+1, temp, ans); // to take 
        temp.remove(temp.size()-1); // backtrack
        helper(nums, i+1, temp, ans); // not to take
    }
}