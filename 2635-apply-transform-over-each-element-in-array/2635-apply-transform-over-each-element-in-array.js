/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let output = [];
    let n = arr.length;
    for(let i=0; i<n; i++){
        let val = fn(arr[i], i);
        output.push(val);
    }
    return output;
};

// let arr = [2,3,4];
// function fn(x, i) {
//     // return n+1
//     // return n+i;
//     // return 42;
// }
// const newArr = map(arr, fn);
// Console.log(newArr);