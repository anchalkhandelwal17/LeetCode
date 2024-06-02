class Solution {
    public int countDays(int days, int[][] meetings) {
        // TC : O(nlogn)
        // SC : O(1)
        if(days < meetings[0][0]) return 0;
        
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int n = meetings.length;
        int ans = 0;
        int start = meetings[0][0];
        ans += meetings[0][0] - 1;
        int end = meetings[0][1];
        for(int i=1; i<n; i++){
            
            start = meetings[i][0];
            if(start - end - 1 >= 0){
                if(days >= end){
                    ans = ans + start - end - 1;
                }
                else{
                    break;
                }
            }
            end = Math.max(end, meetings[i][1]);
        }
        if(days - end > 0){
            ans += days - end;
        }
        return ans;
    }
}