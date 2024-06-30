class Solution {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int req1 = 1;
        int req2 = 0;
        int zeroOneSeq = 0;
        int oneZeroSeq = 0;
        for(int i=0; i<nums.length; i++){
            int val = nums[i] % 2;
            if(val == 0) even++;
            else odd++;

            if(val == req1){
                req1 = 1 - req1;
                oneZeroSeq++;
            }
            if(val == req2){
                req2 = 1 - req2;
                zeroOneSeq++;
            }
        }
        int max1 = Math.max(even, odd);
        int max2 = Math.max(oneZeroSeq, zeroOneSeq);
        return Math.max(max1, max2);
    }
}