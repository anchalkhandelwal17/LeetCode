class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        
        int i=0;
        
        while(i<nums.length){
            
            if(nums[i] == n){
                i++;
            }
            else if(nums[i] != i){
                swap(nums, i, nums[i]);
            }
            else{
                i++;
            }
        }
        
        for(int k=0; k<n; k++){
            if(nums[k] != k){
                return k;
            }
        }
        
        return n;
    }
    
    
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}