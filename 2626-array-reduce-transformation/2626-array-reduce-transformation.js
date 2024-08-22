/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let ans = init;
    if(nums.length === 0) return ans;

    for(let i=0; i<nums.length; i++){
        let val = fn(ans, nums[i]);
        ans = val;
    }
    return ans;
};