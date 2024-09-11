// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
        
//         int i=0;
//         int j=0;
//         int ans = 0;
//         int n = nums.length;
//         int cnt = 0;
//         int oddCnt = 0;
//         while(j < n){
//             if(nums[j] % 2 == 1) {
//                 oddCnt++;
//                 cnt = 0;
//             }

//             while(i <= j && oddCnt == k){
//                 if(nums[i] % 2 == 1) oddCnt--;
//                 i++;
//                 cnt++;
//             }
//             j++;
//             ans = ans + cnt;
//         }
//         return ans;
//     }
// }

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // TC : O(n + n)
        // SC : O(1)
        int i=0, j=0, n=nums.length;
        int cnt = 0, oddCnt = 0, ans = 0;
        while(j < n){
            if(nums[j] % 2 == 1){
                oddCnt++;
                cnt = 0;
            }
            while(i <= j && oddCnt == k){
                if(nums[i++] % 2 == 1) oddCnt--;
                cnt++;
            }
            ans += cnt;
            j++;
        }
        return ans;
    }
}
