class Solution {
    public int longestSubarray(int[] nums) {
     
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
       // System.out.println(max);
        
        int start = 0;
        int end = 0;
        int maxLen = 1;
        
        while(end < nums.length){    
            
            if(nums[end] == max){
                end++;
            }
            else{
                start = ++end;
            }
            
            maxLen = Math.max(maxLen, end-start);
        }
        
        return maxLen;
    }
}