CREATIONAL DESIGN PATTERNS

    A program should not depend on how objects are created and arranged

    Instantiation is an activity that should not always be done in public
        and can often lead to coupling problems

    In java, the simplest way to create an instance of an object is by using
        the new operator
        - fred = new Fred();
        - create a concrete class
    
    Tying your code to a concrete class can make it more fragile and less flexible
        Code may have to be changed as new concrete classes are added
        Your code will not be "closed for modification"
            - to extend with new concrete types, you will have to re-open it
        
    Creational design patterns provide a way to create objects

    Creational design patterns abstract the instantiaion process
        - the creation logic is hidden
        - encapsulates knowledge about which concrete classes the system use
        - programmer may call a method or use another object
          rather than instantiating objects direclty using the new operator
    
    All the system at large knows about the objects is their interfaces as defined
    by abstract classes
        gives the programmer a lot of flexibility in what gets created,
            who creates it, how it gets created, and when
        lets you configure a system with "product" objects that vary widely
            in structure and functionality
        configuration can be static(compile-time) or dynamic(at run-time)
    
    By coding to an interface, you can insulate yourself from a lot of changes
    that might happen to a system down the road

    Sometimes creational patterns are competitors
        - there are cases when either Prototype or Abstract Factory could be profitable
    
    Sometimes creational patterns are complementary
        - builder can use one of the other patterns to implement which components get built
        - prototype can use Singleton in its implementation

    
    Sub-Categories - Class Pattern vs Object Pattern

    Class patterns describe how relationships between classes are defined
        - use inheritance
        - relationships are established at compile time
        - Factory pattern
        - drawback of this approach is that it can require creating a new subclass
          just to change the class of the product
            changes can cascade
            when the product creator is itself created by a factory method,
            then you have to override its creator as well
    
    Object patterns describe relationships between objects
        - use composition
        - relationships are typically created at runtime; more dynamic and flexible
        - abstract factory, singleton, builder, and prototype patterns

    5 creational patterns
        - Factory
        - Abstract Factory
        - Singleton
        - Builder
        - Prototype


