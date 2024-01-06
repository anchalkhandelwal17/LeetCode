class Solution {
    public int minOperations(int[] nums, int k) {
        
        int count = 0;
        int n = nums.length;
        int xor = nums[0];
        
        for(int i=1; i<n; i++){
            xor = xor ^ nums[i];
        }
        
        for(int i=0; i<32; i++){  
            if((1 << i & xor) != (1 << i & k)) count++;
        }
        return count;
    }
}