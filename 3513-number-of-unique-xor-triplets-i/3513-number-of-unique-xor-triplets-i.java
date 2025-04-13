class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int cnt = 0;
        int n = nums.length;
        if(n <= 2) return n;
        while(n != 0){
            n >>= 1;
            cnt++;
        }
        return  (int)(Math.pow(2, cnt));
    }
}