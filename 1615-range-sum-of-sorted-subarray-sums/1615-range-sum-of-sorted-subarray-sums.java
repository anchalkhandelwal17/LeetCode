class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int m = nums.length;
        int mod = (int)(1e9+7);
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum = (sum + nums[j] % mod) % mod;
                list.add(sum);
            }
        }
        Collections.sort(list);
        int ans = 0;
        --left;
        --right;
        for(int i=left; i<=right; i++){
            ans = (ans + list.get(i) % mod) % mod;
        }
        return (ans % mod);
    }
}