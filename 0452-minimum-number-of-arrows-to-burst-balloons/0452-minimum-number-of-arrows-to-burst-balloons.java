class Solution {
    public int findMinArrowShots(int[][] points) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(points, (a, b) -> {
            if(a[1] == b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int arrows = 1;
        int end = points[0][1];
        int n = points.length;
        for(int i=0; i<n; i++){
            int start = points[i][0];
            if(start <= end){
                continue;
            }
            else{
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}