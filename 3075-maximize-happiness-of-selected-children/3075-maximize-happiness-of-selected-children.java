class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length;
        int dec = 0;
        for(int i=n-1; i>=0; i--){
            if(happiness[i] - dec > 0){
                ans = ans + happiness[i] - dec;
                k--;
            }
            if(happiness[i] - dec <= 0 || k == 0){
                break;
            }
            dec++;
        }
        return ans;
    }
}