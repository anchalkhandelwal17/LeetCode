class Solution {
    public boolean containsDuplicate(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.add(x) == false) return true;
        }
        return false;
    }
}