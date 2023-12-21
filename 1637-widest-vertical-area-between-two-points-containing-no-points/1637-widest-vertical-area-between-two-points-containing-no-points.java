class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        
        int maxArea = Integer.MIN_VALUE;
        
        for(int i=0; i<points.length-2; i++){
            maxArea = Math.max(maxArea, points[i+1][0] - points[i][0]);
        }
        return maxArea;
    }
}