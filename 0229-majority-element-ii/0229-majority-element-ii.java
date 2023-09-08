class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int ele1 = Integer.MIN_VALUE;
        int cnt1 = 0;

        int ele2 = Integer.MIN_VALUE;
        int cnt2 = 0;

        int n = nums.length;

        for(int i=0; i<n; i++){
            if(cnt1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                cnt2 = 1;
            }
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;

            else{
                cnt1--;
                cnt2--;
            } 
        }

        cnt1 = 0;
        cnt2 = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
        }

        List<Integer> ans = new ArrayList<>();
        int min = n/3;
        if(cnt1 > min) ans.add(ele1);
        if(cnt2 > min) ans.add(ele2);

        return ans;
    }
}