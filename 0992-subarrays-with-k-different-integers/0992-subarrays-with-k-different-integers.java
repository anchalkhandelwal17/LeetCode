class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // TC : O(2 * (n + n))
        // SC : O(n)
        int atMostK = solve(nums, k);
        int atMostKMinusOne = solve(nums, k-1);

        return atMostK - atMostKMinusOne;
    }

    public int solve(int[] nums, int k){
        if(k <= 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int ans = 0;
        int i=0, j=0;

        while(j < n){
            int num = nums[j];

            map.put(num, map.getOrDefault(num, 0)+1);

            while(map.size() > k){
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }

            ans = ans + (j - i + 1);
            j++;
        }
        return ans;
    }
}