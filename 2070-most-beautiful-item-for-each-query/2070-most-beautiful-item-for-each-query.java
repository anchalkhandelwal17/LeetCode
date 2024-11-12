class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // TC : O(nlogn)
        // SC : O(m)
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for(int i=1; i<items.length; i++){
            items[i][1] = Math.max(items[i][1], items[i-1][1]);
        }

        for(int i=0; i<n; i++){
            ans[i] = find(queries[i], items);
        }
        return ans;
    }
    public int find(int x, int[][] nums){
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid][0] > x){
                end = mid-1;
            }
            else{
                ans = Math.max(ans, nums[mid][1]);
                start = mid+1;
            }
        }
        return ans;
    }
}