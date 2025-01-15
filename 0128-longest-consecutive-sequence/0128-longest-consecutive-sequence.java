class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        
        int ans = 0;

        for (int v : set) {
            if (!set.contains(v - 1)) {
                int cnt = 1;
                int x = v;
                while (set.contains(x + 1)) {
                    cnt++;
                    x++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}