class Solution {
    public int diagonalPrime(int[][] nums) {
        
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(isPrime(nums[i][i])){
                ans = Math.max(ans, nums[i][i]);
            }
            if(isPrime(nums[i][n-i-1])){
                ans = Math.max(ans, nums[i][n-i-1]);
            }
        }
        return ans;
    }
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}