class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        
        int[][] jobs = new int[startTime.length][3];
        
        for(int i=0; i<startTime.length; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a , b) -> (a[1] - b[1]));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,0);
        
        for(int[] job : jobs){
            
            int val = job[2] + map.floorEntry(job[0]).getValue();
            
            if(val > map.lastEntry().getValue()){
                map.put(job[1], val);
            }
        }
        
        return map.lastEntry().getValue();
    }
}