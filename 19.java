SINGLETON

Ensure a class only has one instance
Provide a global point of access to it

the Singleton pattern works by having a special method that is used to instantiate the desired object

when this method is called it checks to see whether the object has already been instantiated
    if it has, the method just returns a reference to the object
    if not, the method instantiates it and return a referene to the new instance

To ensure that this is the only way to instantiate an object of this type,
    the constructor should be protected or private

ADV
    controlled access to sole instance
    reduced name space - improvement over global variables

DISADV
    hinder unit testing; use of static
    hidden dependencies


Singleton vs Dependency injection
    Dependency injection
        a technique whereby one object supplies the dependencies of another object
        it enables you to replace dependencies without changing the class that uses them
        it can be used to avoid statics
    
    Using Dependency injection, you can use constructor or setter injection to pass around a single object
        have the injector create a single object and then inject it via the constructor or setter of any dependent objects
        implements the singleton with less dependencies


    When to use DI over Singleton
        when you want your software to be under unit test 
        to avoid statics, which make it harder to test
        when you have non-stable dependency 
            which refers to or affects the global state, such as an external service, file system, or a database
            it is good practice to inject that dependency to the dependent class
            helps the class explicitly specify everything it needs in order to perform properly
    
    When to use Singleton over DI
        ambient dependencies which span across multiple classes and often multiple layers
            you do not want to pass the inject object to all of these multiple classes
        ex) logger service
            if you tend to log a lot of activites throughout your code base,
            it is not practical to pass the logger instance to every class

Implementation Overview

    Common concepts
        private constructor to restrict instantiation
        private static variables
        public static method that returns the instance of the class
            - global access point to outer world
        
    5 approaches
        Lazy evaluation approach; not recommendable, not multi-thread software
        Synchoronized approach; thread safe, straightforward and effective, but perforamce is not best
        Double-checked locking principle appraoch; thread safe, increased perforamce
        Eager evalutation approach; thread safe, doesn't use lots of resources
                instance is created even when is not needed
        Bill Pugh approach; thread safe, high performace, standard method
                instance is created only when it is needed
                inner static helper class is used to create Singleton class
                