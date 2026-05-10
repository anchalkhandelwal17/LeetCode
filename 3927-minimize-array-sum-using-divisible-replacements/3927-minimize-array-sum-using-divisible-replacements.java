class Solution {
    public long minArraySum(int[] nums) {
        boolean[] vis = new boolean[100001];
        for(int n : nums){
            vis[n] = true;
        }
        int[] divisor = new int[100001];
        for(int i=1; i<100001; i++){
            if(vis[i]){
                for(int j=i; j<100001; j+=i){
                    if(divisor[j] == 0){
                        divisor[j] = i;
                    }
                }
            }
        }
        long sum = 0;
        for(int n : nums){
            sum += divisor[n];
        } 
        return sum;
    }
}