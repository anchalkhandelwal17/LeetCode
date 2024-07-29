class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // TC : O((n + m) * logn)
        // SC : O(n)
        Arrays.sort(nums);
        int n = nums.length;
        long[] pref = new long[n+1];
        for(int i=1; i<=n; i++){
            pref[i] = pref[i-1] + nums[i-1];
        }
        ArrayList<Long> ans = new ArrayList<>();
        for(int a : queries){
            int idx = bs(nums, a);

            long x = 1L * a * idx - pref[idx];
            long y = pref[n] - pref[idx] - 1L * a * (n - idx);
            ans.add(x + y);
        }
        return ans;
    }

    public int bs(int[] nums, int x){
        int s = 0;
        int e = nums.length-1;
        while(s <= e){
            int m = (s + e)/2;
            if(nums[m] <= x){
                s = m+1;
            }
            else e = m-1;
        }
        return s;
    }
}