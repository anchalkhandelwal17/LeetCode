class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int idx = 0;
        int[] ans = new int[n - k + 1];

        while(end < n){

            if(end - start + 1 <= k){
                map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            }
            else{
                ans[idx++] = getMin(map, x);
                if(map.get(nums[start]) == 1){
                    map.remove(nums[start]);
                }
                else{
                    map.put(nums[start], map.getOrDefault(nums[start], 0)-1);
                }
                map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
                start++;
            }
            end++;
        }
        ans[idx++] = getMin(map, x);
        return ans;
    }

    public int getMin(TreeMap<Integer, Integer> map, int x){

        int freq = 0;
        for(int key : map.keySet()){
            int val = map.get(key);

            freq += val;

            if(freq >= x){
                return Math.min(0, key);
            } 
        }
        return 0;
    }
}