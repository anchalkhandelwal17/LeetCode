class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int ans = 0;
        long sum = 0;
        int j=0;
        int i=0;

        while(j < arr.length){

            sum += arr[j];
            if(j-i+1 < k){
                j++;
            }
            else if(j -i+1 == k){
                if(sum/k >= threshold){
                    ans++;
                }
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }
}