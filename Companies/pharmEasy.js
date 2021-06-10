
Sync and async JS

console.log('1');
setTimeout(function () {
    console.log('2');
}, 0);

new Promise((resolve) => resolve('3')).then(data => { console.log(data) })


console.log('4');


OP:

1
4
3
2



a = []

a.map()


A.__proto__.__proto__.__proto__

A.__proto__.map = function (callback, i) {
    Let arr = this;
    Let newarr = [];
    for (let i = 0; i < arr.length; i++) {
        newark.push(callback(arr[i]);
    }
    return newarr;
}



a.map(obj, i, arr)=> {
    console.log(“obj”, obj, ”i”, i)
}


Bind ???



    function greet(age, address) {
        console.log(`Hello ${this.name}.`);
    }

Let obj = {
    “Name”: “Ralph”
}

greet.call(obj, age, address);
greet.apply(obj, [age, address]);



Promise ??

    Is function object??

        shallow clone vs deep clone

Let obj1 = {};
Let obj2 = JSON.parse(JSON.stringify(obj1));


Box - sizing: ’border - box’

let arr = [‘java’, ’angular’, ’javascript]
let searchTerm = ‘ava’


    [‘java’, ’javascript’]

Let newArr = arr.filter((elem) => {
    return elem.indexOf(searchTerm) != -1;
});

Let arr = [1, 2, 1, 14, 1];
Let newArr = [];
Let map = new Map();
for (let index: arr) {
    Let elem = arr[index];
	if (!map[elem]) {
        Map[elem] = true;
        newArr.push(elem);
    }
}
console.log(newArr);


