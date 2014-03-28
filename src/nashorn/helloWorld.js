var HelloHelper = Java.type("nashorn.HelloHelper");
var helloHelper = new HelloHelper();

function sayHelloImpl(name) {
    return helloHelper.getPrefix() + " " + name;
}

function newHelloWorld() {
    return new Packages.nashorn.HelloWorld(){
        sayHello: sayHelloImpl
    }
}

newHelloWorld();