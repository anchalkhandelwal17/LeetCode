class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        for(int x : set){

            if(!set.contains(x-1)){

                int y = x;
                int cnt = 1;

                while(set.contains(y+1)){
                    cnt++;
                    y++;
                }

                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
