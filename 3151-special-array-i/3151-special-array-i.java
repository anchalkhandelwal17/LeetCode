class Solution {
    public boolean isArraySpecial(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        for(int i=0; i<nums.length-1; i++){
            int a = nums[i];
            int b = nums[i+1];
            
            if(a%2 == 0){
                if(b%2 == 1){
                    continue;
                }
                else return false;
            }
            if(b%2 == 1){
                if(a%2 == 0){
                    continue;
                }
                else return false;
            }
        }
        return true;
    }
}