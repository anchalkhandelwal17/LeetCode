class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> (a-b));
        max = new PriorityQueue<>((a,b) -> (b-a));
    }
    
    public void addNum(int num) {
        if(max.size() == 0 || max.peek() >= num){
            max.add(num);
        }
        else{
            min.add(num);
        }
        balance();
    }

    public void balance(){
        if(max.size() - min.size() > 1){
            min.add(max.poll());
        }
        else if(min.size() - max.size() > 1){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() > min.size()){
            return max.peek();
        }
        else if(min.size() > max.size()){
            return min.peek();
        }
        else{
            return (min.peek() + max.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */