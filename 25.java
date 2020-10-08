BUILDER - Overview

The builder design pattern separates the construction of a complex object from its representation

    Use the same construction processes to create the same object
    However, these processes can create different representations of the object
    Uses simple objects and a step by step approach to create the object
    The builder class is independent of other objects

    ex) creating computers
    - one can demand a 500 GB hard disk with intel processor
    - another can demand a 250 GB hard disk with AMD processor

    ex) building vacation plan for disney world
    - guests can choose hotel, types of admission tickets, restraunts, special events
    - you will need a flexible design
    - the creation of the trip planner is encapsulated in an object(a builder)
    - have our client ask the builder to construct the trip planner
    - builder design pattern can provide a way to create the complex structure without mixing it with the steps for creating it

    ex) java.lang.StringBuilder#append()

Why use?
    
    To solve problems with the Factory and Abstract Factory design patterns
    ; these patterns do not work well when the Object to be created contains lots of attributes

    3 major issues
    - too many argument to pass from the client to the Factory class 
        ; error-prone, hard to maintain
    - optional parameters
        ; Factory pattern force to send all parameters
    - object is complex to create
        ; the complexity will be part of Factory class

Advantages

    Hide the complex construction process
    Product implementations can be swapped in and out since the client can only see the abstract interface
    Finer control over the constrcution process than other creational patterns
    

Disadvantages

    Requires some amount of code duplication
    Constructing objects requires more domain knowledge of the client than when using Factory pattern
    Builder patten should not be used when a mutable object is needed
        * mutable object: an object that can be modified after the creational process is done



Builder - implementation

The main participants
    - Builder
        Specifies an abstract interface for creating parts of a Product object
        Defines an operation for each component that a director may ask it to create

    - ConcreteBuilder
        Constructs and assembles parts of the product by implementing the Builder interface
        Overrides operations for components
        Defines and keeps track of the representation it creates
        Builder would return child nodes to the director, 
            which then would pass them back to the builder to build the parent nodes
        Provides an interface for retrieving the product( getProduct() )
        Each ConcreteBuilder contains all the code to create and assemble a particular kind of product


    - Director
        Constructs an object using the Builder interface

    - Product
        Represents the complex object
        ConcreteBuilder builds the product's internal representation

Process

    The client creates the Director object
        ; configure it with the desired Builder object
    The Director notifies the builder whenever a part of the product should be built
    The Builder handles requests from the director and add parts to the product
    The Client retrieves the product from the builder


