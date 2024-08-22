/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {

    let filteredArr = [];
    for(let i=0; i<arr.length; i++){
        if(fn(arr[i], i)){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;

    // using the inbuilt filter function
    // let filteredArr = [];
    // let idx = 0;
    // filteredArr = arr.filter(val => fn(val, idx++));
    // return filteredArr;
};

// const ans = filter(arr, fn);
// console.log(ans()); 
