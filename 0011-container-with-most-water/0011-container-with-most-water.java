class Solution {
    public int maxArea(int[] height) {
        // TC : O(n)
        // SC : O(1)
        int ans = 0;
        int n = height.length;

        int i = 0;
        int j = n-1;

        while(i < j){
            int l = height[i];
            int r = height[j];
            int min = Math.min(l, r);
            int area = min * (j - i);
            ans = Math.max(ans, area);

            if(height[i] < height[j]) i++;
            else if(height[i] > height[j]) j--;
            else{
                i++;
                j--;
            }
        }
        return ans;
    }
}