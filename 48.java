FACADE Design Pattern

Overview
    The facade design pattern provides an unified interface to a set of interfaces in a system
        - defines a higher level interface that makes the subsystem easier to use
        - does not add any functionality
    
    The face of the building
        - passers do not know complexities such as wiring, pipes, they can only see glassy face of building
    
    more like a helper for clinet applications
        - does not hide subsystem interface from the clinet
    
    Whether to use Facade is completely dependent on client code

    Can be applied at any point of development, usually when the number of interfaces grows

    subsystem interfaces are not aware of Facade and they should not have any reference to the Facade interface


Why Facade?
    Subsystems are groups of classes or groups of classes and other Subsystems

    Structureing a system into subsystems helps reduce complexity

    The interface exposed by the classes in a subsystem or set of subsystems can become quite complexities

    One way to reduce this complexity is to introduce a facade object
        - Provide a single, simplified interface
    
    When you want to layer your subsystems
        - use a facade to define an entry point to each subsystem level


Facade vs Adapter
    When you need to use an existing class and its interface is not the one you need
        Use an Adapter
    
    When you need to simplify and unify a large interface or complex set of interfaces
        Use a facade

    An adapter changes an interface into one a client expects

    A facade decouples a client from a complex subsystem

    An adapter wraps an object to change its interface

    A decorator wraps an obejct to add new behaviors and responsibilities

    A facade wraps a set of objects to simplify
