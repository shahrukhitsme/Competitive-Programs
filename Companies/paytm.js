console.log(data) //error 
let data = 30;
console.log(data)

for (let i = 0; i < 5; i++) {
    setTimeout(() => { console.log(i) }, 0);// ref , let 0,1,2,3,4, 55555
}
data = 40;

function abc() {
    Var a = 2;
    Return a;
}

abc();
Let obj = {
    Param: {
        innerParam: () => { console.log(this) }

    }
}
obj.param.innerParam() //arrow -> null, function->

Function timeout(api, 2s){
    Let promise = new Promise(function (resolve, reject) {
        Let timer = setTimeout(() => {
            reject(“Time exceded”);
        }, time);
        api.then(function (result) {
            clearTimeout(timer);
            resolve(result);
        }.catch(function (error) {
            clearTimeout(timer);
            reject(result);
        }
}
}
}
Api = fetch(‘www.api.com / dat’)

Function sum(a){
    Return function(b) {
        Return a + b;
    }
}

Let add2 = sum(2);

add2(3);

sum(2)(3);

sum(1)(2)(3)(4)(5)//

sum(1)(2)(3) //

Function sum(a){
    Return function(b) {
        if (b)
            Return sum(a + b);
        Return a;
    }
}
Let summation = sum(1)(2)(3);
summation();

console.log(sum(1)(2)(3));

998 9 -> 9 -> 8 - head
556 5 -> 5 -> 6 - head
1554 1 -> 5 -> 5 -> 4
154
Function add(link1, link2){
    if (link1.next == null || link2.next == null)
        Return { carry, sum }
    Let carry = add(link1.next, link.next);
    raturn{ }
}

Function add(link1, link2){
    Let root = new Li
}

css position, centre an element
html5 semantics, async - defer
