class Solution {
    public int minOperations(int[] nums, int k) {
        
        int xor = nums[0];
        for(int i=1; i<nums.length; i++){
            xor ^= nums[i];
        }
        int ops = 0;
        for(int i=0; i<32; i++){
            int mask = (1 << i);
            if((xor & mask) != (k & mask)){
                ops++;
            }
        }
        return ops;
    }
}