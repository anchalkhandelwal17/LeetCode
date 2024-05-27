class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        // TC : O(n*sqrt(n))
        // SC : O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            int val = num * k;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        long ans = 0;
        for (int num : nums1) {
            for(int i=1; i*i<=num; i++){
                if(num % i == 0){
                    if(map.containsKey(i)){
                        ans += map.get(i);
                    }

                    if(i != num/i && map.containsKey(num/i)){
                        ans += map.get(num/i);
                    }
                }
            }            
        }
        
        return ans;
    }
}