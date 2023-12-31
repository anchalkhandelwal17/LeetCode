class Solution {
    public int findMinArrowShots(int[][] points) {
      
        Arrays.sort(points, (a , b) -> Integer.compare(a[1] , b[1]));
        
        int arrowsReq = 1;
        int diameterEnd = points[0][1];
        
        for(int i=1; i<points.length; i++){
            
            int diameterStart = points[i][0];
            
            if(diameterEnd >= diameterStart) continue;
            else{
                arrowsReq++;
                diameterEnd = points[i][1];
            }
        }    
        return arrowsReq;
    }
}
