class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0, cnt2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                if(cnt % 2 == 0){
                    cnt++;
                    while(i < n && nums[i] == 0){
                        i++;
                    }
                    i--;
                }
            }
            else if(nums[i] == 1){
                if(cnt % 2 == 1){
                    cnt++;
                    while(i < n && nums[i] == 1){
                        i++;
                    }
                    i--;
                }
            }
        }
        return cnt;
    }
}