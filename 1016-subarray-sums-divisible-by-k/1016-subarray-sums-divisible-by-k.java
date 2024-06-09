class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // TC : O(n)
        // SC : O(k)
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            sum %= k;
            if(sum < 0) sum = (sum + k) % k;
            if(map.containsKey(sum)){
                cnt += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum , 0)+1);
        }
        return cnt;
    }
}