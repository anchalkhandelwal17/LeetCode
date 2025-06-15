class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] ch = new int[26];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            ch[c - 'a'] = i;
        }

        int start = 0;
        int size = 0;
        for(int end=0; end<s.length(); end++){
            size++;
            char c = s.charAt(end);
            start = Math.max(start, ch[c - 'a']);

            if(start == end){
                list.add(size);
                size = 0;
                start = end+1;
            }
        }
        return list;
    }
}
// 