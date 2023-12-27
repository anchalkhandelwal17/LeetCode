class Solution {
    public int minCost(String colors, int[] neededTime) {
       
        int min_cost = 0;
        
        for(int i=0; i<colors.length(); i++){
            int total_cost = neededTime[i] , max_cost = neededTime[i];
            
            while(i < colors.length()-1 && colors.charAt(i) == colors.charAt(i+1)){
                total_cost  += neededTime[i+1];
                max_cost = Math.max(max_cost, neededTime[i+1]);
                i++;
            }
            
            min_cost = min_cost + (total_cost - max_cost);
        }
        return min_cost;
    }
}