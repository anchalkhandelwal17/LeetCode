class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // TC : O(n * 2 ^ n) + O(nlogn), SC : O(n * 2 ^ n)
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> list){
        // base condition
        if(i == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(nums, i+1, temp, list);   // pick
        temp.remove(temp.size()-1);
        // taking care of duplicates by simply ignoring them
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i+=1;
        }
        helper(nums, i+1, temp, list);   // not pick
    }
}