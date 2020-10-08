Design Principle
    Programming to an interface
    Favor Composition over inheritance
    Delegation principles
    Single responsibility
    Open closed design
    Liskov substitution
    Interface segregation
    Dependency injection(inversion)

Common characteristics
    
    all contains some form of modularization
    there is a seperation of concerns for each module
        - each module knows what another module does, but it does not know how
        - strive for high cohesion / low coupling
            https://www.coengoedegebure.com/solid-design-principles/
            Cohesion refers to what a class or module can do. 
            High cohesion means that the class is focused on what it should be doing 
            as it contains only methods relating to the intention of the class.

            Coupling refers to how related or dependent two classes or 
            modules are towards each other. For low coupled classes, 
            a major change in one class has a low impact on the other.

    they identify the aspects of your application that vary and separate them from what stays the same

    they favor abstraction over implementation
        - the design depends on an abstraction layer
            makes your design open for extensions
            the abstraction is applied on the dynamic parts of the application
        - hide low-level implementation through an abstract layer
            low-level modules have a very high possibility to be changed regularly,
            so they are separate from high-level modules

    they do not contain duplication
        - instead, use abstraction to abstract common things in one place
        - duplicated block of code -> making it a separate methods
        - duplicated hard-coded value -> making it a public final constant

    the design for classes/methods/modules have a single focus and single responsibility
        - minimizes regressions

    encapsulation is a big deal
        - encapsulate the code that you expect or supect to be changed
        - it is easier to test and maintain proper encapsulated code
    
    these principles will suggest making variable and methods private by default
        increasing access step by step (from private to protected and not public)


Common Streategies that design patterns use

    patterns are designed to use interfaces

    patterns favor aggregation over inheritance
        - aggregation : collection of things that are not part of it
            ex) airplanes at an airport
        - composition : something is a part of another things
            ex) wheels on an airplane
        - difference: when the objects goes away, should its parts also go away?

    patterns use encapsulation for variation

    patterns favor alternatives to large inheritance hierarchies
        - design patterns enable you or your team to create designs for complex problems 
            that do not require large inheritance hierarchies
        - avoid large inheritance hierarchies will result in improved designs

------------------------------------------------------------------------------------------------

Design Smells

Rigidity
    - the tendency of software to be difficult to change
    - a single change causes a cascade of subsequent changes in dependent modules (tight coupling)
    - the more modules that must be changed, the more rigid the design

Fragility
    - the tendency of software to break in many places when a single change is made
    - the problems often occur in places that have no obvious relation to the area that was changed
    - as the fragility of a module increaes, the likelihood 
    	that a change will introduce unexpected problem rise 

Immobility
    - contains parts that could be useful in other systems
    - but the effort and risk of separating them from the original system are too great

Viscosity
    - a high viscosity if a design-preserving change is more difficult to use than a hack
    - if running unit tests and compilation takes a lot of time, it is likely for a developer
    	to bypass procedures and implement a hack without running all automated tests

Needless repetition
    - copy and pasting code throughout the system
    - happens when necessary abstractions have not been made

Opacity
    - tendency of a module to be difficult to understand
    - when code is not written in a clear and expressive manner, it is said to be opaque
    - code that evolves over time tends to become more difficult to understand over time

Needless complexity
    - in a passionate attempt to avoid the other smells
    - developers introduce all sorts of abstractions and preparations for potential changes
    - sort of "over-design"
    - good software design is lightweight, flexible, easy to read and understand, 
    	above all, easy to change
    - no need to keep into account all potential changes in the future

Design Smells in Java
    - several classes that duplicate 90% of each other -> use inheritance
    - too many public classes/members/methods -> encapsulation
    - too large class -> too many single concept into one massive class



    




