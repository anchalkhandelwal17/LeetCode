class Solution {
    public long countCompleteDayPairs(int[] hours) {

        long[] rem = new long[24];
        long ans = 0;
        int n = hours.length;
        for(int i=0; i<n; i++){

            int remainder = hours[i] % 24;
            for(int j=0; j<24; j++){
                if((remainder + j) % 24 == 0){
                    ans += rem[j];
                }
            }
            rem[remainder]++;
        }
        return ans;
    }
}