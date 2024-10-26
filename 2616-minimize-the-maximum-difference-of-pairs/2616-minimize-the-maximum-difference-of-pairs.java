class Solution {
    public int minimizeMax(int[] nums, int p) {
        // TC : O(n log(1e9))
        // SC : O(1)
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 1) return 0;
        
        int lo = 0;
        int hi = (int)(1e9);
        int ans = 11111111;
        
        while(lo <= hi){
            int m = (lo + hi) / 2;
            
            if(check(nums, p, m)){
                hi = m-1;
                ans = m;
            }
            else{
                lo = m + 1;
            }
        }
        return ans;
    }
    
    public boolean check(int[] nums, int p, int m){

        int cnt = 0;
        int i = 0;
        while(i < nums.length-1 && cnt < p){
            if(nums[i+1] - nums[i] <= m){
                cnt++;
                i += 2;
            }
            else{
                i++;
            }
        }
        return cnt >= p;
    }
}