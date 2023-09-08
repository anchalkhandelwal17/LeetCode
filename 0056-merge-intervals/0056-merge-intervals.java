class Solution {
    public int[][] merge(int[][] intervals) {

        // First sorting the array
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return a[0] - b[0];
            }
        });

        // creating a list of lists and storing all the non-overlapping intervals lists in this list
        List<List<Integer>> list = new ArrayList<>();

        // iterating through all the intervals in the array
        for(int i=0; i<intervals.length; i++){

            // creating a new list if the list is empty or if the start of current interval is greater than the end of previous interval 
            if(list.isEmpty()||intervals[i][0]>list.get(list.size()-1).get(1)){
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                
            }

            // updating the current list's end if the start of current interval is less than equal to the previous interval's end
                else{
                    list.get(list.size()-1).set(1, Math.max(list.get(list.size()-1).get(1), intervals[i][1]));
                }
            
        }

        // creating a new ans array of size list which was used to store all the non-overlapping intervals
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}