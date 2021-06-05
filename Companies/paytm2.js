
//  add(1, 2) || add(1)(2) => returns the sum of both params
let add = function (...args) {
    console.log(args);
    if (args.length == 2) return args[0] + args[1];
    else if (args.length == 1) {
        return function (b) {
            return args[0] + b;
        };
    }
};

console.log(add(1, 2));
console.log(add(1)(2));

// add2(1, 2, 3...) || add2(1)(2)(3)... => returns the sum of all  params (variable number)

let add2 = function (...args) {
    console.log(args);
    if (args.length == 1) return args[0];
};

let add3 = function (a) {
    return function (b) {
        if (b) return add3(a + b);
        return a;
    };
};
console.log(add3(1)(2)(3)(4)());

let add4 = function (...args) {
    let sum = 0;
    for (let index in args) {
        sum += args[index];
    }
    return sum;
};
console.log(add4(1, 2, 3, 4, 5));

let add5 = function (...args) {
    if (args.length > 1) return add4(...args);
    return add3(args[0]);
};

console.log(add5(1, 2, 3, 4, 5));
console.log(add5(1)(2)(3)(4)(5)());

// Combine the above two cases: add(1, 2)(3)(4)(4, 5, 6)...
// variable number of params per call, variable number of calls
let add6 = function (...args) {
    let sum = add4(...args);
    return function (...args2) {
        if (args2.length == 0) return sum;
        return add6(...args2, sum);
    };
};

console.log(add6(1, 2)(3)(4)(4, 5, 6)());
