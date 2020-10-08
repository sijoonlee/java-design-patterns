COMPOSITION OVER INHERITANCE

composition
    Has-A relationship
    ; an object contains another object as a member variable

    implies a relationship where the child cannot exist independent of the parent
        - wheels on an airplane ; part of whole
        - rooms in a house ; rooms do not exist separately to a house
        - cells in a body ; cells get destroyed as a body gets destroyed

    when you put two classes together like this you are using composition
        - instead of inheriting their behaviour, the houses get their behavior 
          by being composed with the right behavior object
        
aggregation
    Has-A relationship
    ; collection of things that are not part of it

    implies a relationship where the child can exist independelty of the parent
        - students in a class ; students still exits without a class
        - tires on a car ; the tires can be taken off, and replaced by a different one

aggregation and composition are almost completely identical except that
composition is used when the life of the child is completely controlled by the parent
    the distinction loses much of its importance in languages that have garbage collection
    ; you do not need to concern yourself with the life of the object


Why?

favoring object composition over class inheritance helps you keep each class
encapsulated and focused on one task
    your classes and class hierachies will remain small
    and will be less likely to grow into unmanageable monsters

inheritance breaks encapsulation because sub-classes are dependent upon the base class behavior
    - inheritance is tightly coupled whereas composition is loosely coupled
    - when behavior of super class changes, functionality in sub-class may get broken, 
      without any change on its part

java does not supprot multiple inheritance
    composition can be a "work-around" to this

most design patterns favor composition over inheritance
    - strategy
    - decorator

composition offers better test-ability of a class than when using inheritance
    - you can easily provide a mock implementation of the classes that you are using
    - when designning using inheritance it is harder to test
        because you need to mock both the base and subclasses
    - test driven development

composition is a more flexible and extensible mechanism to reuse existing code
    - do not use inheritance just for the sake of code reuse

composition allows for code reuse from final classes
    - impossible with inheritance because you cannot extend a final class in Java

