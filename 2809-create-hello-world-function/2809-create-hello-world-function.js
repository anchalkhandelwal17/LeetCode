/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World";
    }
};

const f = createHelloWorld();
f("a", 45, null); // "Hello World"
