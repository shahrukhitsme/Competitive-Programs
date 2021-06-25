//Async dependency task resolver
//First argument is the callback which would be called after all the dependent Jobs are resolved. Dependencies are passed as an array in the second argument.

class Job {
    
    constructor(callback, dependencies=[]){
        this.callback = callback;
        this.dependencies = dependencies;
        this.dependents = [];
        this.completed = false;
        this.subscribeDependencies();
    }
    
    subscribeDependencies(){
        if(this.dependencies.length == 0)
            this.callback(this.finishCallback.bind(this));
        for(let index in this.dependencies){
            this.dependencies[index].subscribe(this);
        }
    }
    
    finishCallback(){
        this.completed = true;
        for(let index in this.dependents){
            this.dependents[index].notify(this);
        }
    }
    
    subscribe(dependent){
        if(this.completed)
            dependent.notify(this);
        else
            this.dependents.push(dependent);
    }
    
    notify(dependency){
        this.dependencies = this.dependencies.filter(value => value!=dependency );
        if(this.dependencies.length == 0)
            this.callback(this.finishCallback.bind(this));
    }
}




let a = new Job(function (finish) {
        setTimeout(function () {
            console.log('a done');
            console.log(new Date().getTime());
            finish();
        }, 100);
      },[])

let b = new Job(function (finish) {
        setTimeout(function () {
            console.log('b done');
            console.log(new Date().getTime());
            finish();
        }, 200);
      })

let  c = new Job(function (finish) {
        setTimeout(function () {
            console.log('c done');
            console.log(new Date().getTime());
            finish();
        }, 300);
      },[])

let d = new Job(function (finish) {
        setTimeout(function () {
          console.log('d done');
           console.log(new Date().getTime());
          finish();
        }, 1000);
      },[a,b])

let e = new Job(function (finish) {
        setTimeout(function () {
          console.log('e done');
           console.log(new Date().getTime());
          finish();
        }, 1200);
    },[d])

