class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        
        int n = courses.length;

        int startVal = 0;
        for(int i=0; i<n; i++){
            startVal += courses[i][0];
            pq.offer(courses[i][0]);
            if(startVal > courses[i][1]){
                startVal -= pq.poll();
            }
        }
        return pq.size();
    }
}

// courses from 1 -> n
// courses[i] = [duration[i], lastDay[i]]
// couses shoudl be contin for duration[i] and should be finished before lastDay[i]
// start from day 1