class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            
            int res = nums[i];
            
            for(int j=i; j<nums.length; j++){
                if(nums[j] < k) break;
                res = gcd(res, nums[j]);
                if(res == k) count++;
            }
        }
        return count;
    }
    
//     public int gcd(int a, int b){
//         int num = Math.min(a, b);
        
//         while(num > 0){
//             if((a % num == 0) && (b % num == 0)){
//                 return num;
//             }
//             num--;
//         }
//         return 1;
//     }
    
    public int gcd(int a, int b){
        if(a == 0) return b;
        
        return gcd(b%a, a);
    }
}