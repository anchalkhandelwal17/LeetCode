class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int n = nums.length;
        boolean[] flag = new boolean[1001];
        countPrimes(flag);
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]) continue;
            boolean temp = false;
            for(int j=2; j<nums[i]; j++){
                if(flag[j] == false && nums[i]-j < nums[i+1]){
                    nums[i] = nums[i]-j;
                    temp = true;
                    break;
                }
            }
            if(!temp) return false;
        }
        // System.out.println(Arrays.toString(nums));
        return true;
    }
    
    public void countPrimes(boolean[] flag) {
        
        for(int i=2; i*i<1001; i++){
            if(!flag[i]){
                for(int j=i*i; j<1001; j+=i){
                    flag[j] = true;
                }
            }
        }
    }
}