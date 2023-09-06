class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Time Complexity:O(2^n*k) -- Assume if all the elements in the array are unique then the no. of subsequence you will get will be O(2^n). we also add the ds to our ans when we reach the base case that will take “k”//average space for the ds.
        // Space Complexity:O(k*x) -- if we have x combinations then space will be x*k where k is the average length of the combination.

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, new ArrayList<>(), ans, target);
        return ans;
    }

    public void helper(int i, int[] candidates, List<Integer> temp, List<List<Integer>> ans, int target){
        // base condition
        // if target becomes equal to 0 we have found one of our possible combination, so add it to ans list
         if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        else if(i == candidates.length || target < 0){
            return;
        }
        // pick
        temp.add(candidates[i]);
        helper(i+1, candidates, temp, ans, target-candidates[i]);
        
        // backtrack and remove previous item from the list
        temp.remove(temp.size()-1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i+=1;
        }
        // not pick
        helper(i+1, candidates, temp, ans, target);
    }
}