class Solution {
    public int splitNum(int num) {
        
        List<Integer> list = new ArrayList<>();
        
        while(num != 0){
            list.add(num % 10);
            num /= 10;
        }
        Collections.sort(list);

        int a = 0;
        int b = 0;
        boolean flag = true;
        
        for(int i=0; i<list.size(); i++){
            if(flag){
                a = a * 10 + list.get(i);
            }
            else{
                b = b * 10 + list.get(i);
            }
            flag = !flag;
        }
        return a + b;
        
    }
}