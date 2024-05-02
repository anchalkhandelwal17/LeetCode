class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         for(int i=0; i<nums.length/2; i++){
//             pq.offer((long)(nums[i] * nums[i]));
//         }
        
        
        int ans = 0;
        int i = 0;
        for(int j=nums.length/2; j<nums.length; j++){
            // long a = nums[i];
            // long b = pq.poll();
            // System.out.println(a + "-----" + b);
            // if(b <= a){
            //     ans+=2;
            // }
            
            long val = nums[i] * 2;
            System.out.println(val + "-----" + nums[j]);
            if(val <= nums[j]){
                i++;
                ans+=2;
            }
            
            if(i == nums.length/2){
                break;
            }
            
        }
        return ans;
    }
}