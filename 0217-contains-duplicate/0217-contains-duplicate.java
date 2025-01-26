class Solution {
    public boolean containsDuplicate(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}