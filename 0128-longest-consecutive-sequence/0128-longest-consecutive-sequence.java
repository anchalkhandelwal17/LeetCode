class Solution {
    public int longestConsecutive(int[] nums) {
     
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int maxSeq = 0;

        for(int n : set){
            if(!set.contains(n-1)){
                int x = n;
                int currSeq = 1;
                while(set.contains(x+1)){
                    x = x+1;
                    currSeq++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }
        }
        return maxSeq;
    }
}