/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let val = init;
    return {
        increment : function() {
            val = val + 1;
            return val;
        },
        decrement : function() {
            val = val - 1;
            return val;
        },
        reset : function() {
            val = init;
            return val;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */