class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        BitSet ans = new BitSet();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                set.add(nums[i] ^ nums[j]);
            }
        }

        for(int x : set){
            for(int y : nums){
                ans.set(x ^ y);
            }
        }

        return ans.cardinality();
    }
}