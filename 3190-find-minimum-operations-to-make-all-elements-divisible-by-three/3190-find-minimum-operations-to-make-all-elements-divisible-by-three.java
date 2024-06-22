class Solution {
    public int minimumOperations(int[] nums) {
        
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            cnt = cnt + Math.min(add(nums[i]), sub(nums[i]));
        }
        return cnt;
    }
    public int add(int num){
        int cnt = 0;
        while(num % 3 != 0){
            cnt++;
            num++;
        }
        return cnt;
    }
    public int sub(int num){
        int cnt = 0;
        while(num % 3 != 0){
            cnt++;
            num--;
        }
        return cnt;
    }
}