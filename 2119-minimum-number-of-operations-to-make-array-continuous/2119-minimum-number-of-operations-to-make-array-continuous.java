class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;

        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }

        int[] uniqueArr = new int[set.size()];
        int idx = 0;
        for(int ele : set){
            uniqueArr[idx++] = ele;
        }
        Arrays.sort(uniqueArr);

        int j=0;
        for(int i=0; i<uniqueArr.length; i++){
            while(j < uniqueArr.length && uniqueArr[j] < uniqueArr[i]+n){
                j++;
            }

            int cnt = j-i;
            ans = Math.min(ans, n-cnt);
        }
        return ans;     
    }
}