class Pair {
    int idx;
    char c;
    public Pair(int idx, char c){
        this.idx = idx;
        this.c = c; 
    }
}
class Solution {
    public int addMinimum(String word) {
        HashMap<Pair, Integer> map = new HashMap<>();
        return solve(0, word, 'a', map);
    }

    public int solve(int i, String word, char charReq, HashMap<Pair, Integer> map) {
        // base case

        if(i == word.length()){
           if(charReq == 'a') return 0;
           else if(charReq == 'b') return 2;
           else return 1;
        }

        // Pair p = new Pair(i, charReq);
        // if(map.containsKey(p)){
        //     return map.get(p);
        // }

        int a = 0;
        int b = 0;
        int c = 0;
        char ch = word.charAt(i);

        if (charReq == 'a') {
            if (ch == 'a') {
                a = 0 + solve(i + 1, word, 'b', map);
            }
            else a = 1 + solve(i, word, 'b', map);
        }
        else if (charReq == 'b') {
            if (ch == 'b') {
                b = 0 + solve(i + 1, word, 'c', map);
            }
            else b = 1 + solve(i, word, 'c', map);
        }
        else if(charReq == 'c'){
            if(ch == 'c'){
                c = 0 + solve(i+1, word, 'a', map);
            }
            else c = 1 + solve(i, word, 'a', map);
        }

        int val = a + b + c;
        map.put(new Pair(i, charReq), val);

        return val;
    }
}

// looking at
// the constraints it's
// lookinng like
// recursion problem..

// we don't
// actually have
// to insert
// like edit
// distance dp
// problem

// we
// have to
// work with
// indices rather

// first a
// should come
// then b
// then c

// now how can we memoize this ?
// we can use hashmap proly