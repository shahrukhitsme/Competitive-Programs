//polyfill for reduce

//let and var

//hoisting

/*
var b = 1;
function outer(){
    console.log(b);
    var b=2;
    function inner(){
        console.log(b);
        var b=3;
        console.log(b);
    }
    inner();
}
outer();
*/

/*
var obj1 = {0:1,1:2,2:3};
var obj2 = {0:1,1:2,2:3};
var obj3 = [0,1,2];
Implement a function to compare objects.
Ex: 
equal(obj1, obj2) -> true
equal(obj1, obj3) -> false
*/

//different types of position in css

//parseBlocking, renderblocking events

//async, defer

/*
for(var i=0; i<3; i++){
    setTimeout(()=>{
        console.log(i);
    },10);
}

for(let i=0; i<3; i++){
    setTimeout(()=>{
        console.log(i);
    },10);
}
*/

//event loop, priority of promise to a setTimeout