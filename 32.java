Adapter Pattern

Converts an interface of a class into another interface that clients expect
    works as bridge between two incompatible interfaces
    known as "adapter" or "wrapper"

The adapter acts to decouple the client from the implemented interface
    encapsulates any future changes
    client does not need to be modified each time it needs operate against a difficult interface

full of good OO design principles
    use of object composition to wrap the adaptee with an altered interface
        can use an adapter with any subclass of teh adaptee
    binds the client to an interface, not an implementation

When to use Adapter Pattern
    When you want to use an existing class, and its interface doesn't match the one you need
    When you want to create a resuable class that cooperates with unrelated or unforeseen classes
    When you need to use several existing subclasses and it is impractical to adapt their interface by subclassing every one
        - an object adapter can adapt the interface of its parent class

Ex) AC adapters, card reader
Ex) java.util.Arrays#asList()
    java.io.InputStreamReader(InputStream) (return a Reader)
    java.io.OutputStreamWriter(OutputStream)(return a Writer)


Object Adapter implementation

    Composition - the adapting object contains the adapted object

    Participants
        Target: defines the domain-specific interface that Client uses
        Client: collaborates with objects conforming to the Target interface
        Adaptee: defines an existing interface that needs adapting
        Adapter: adapts the interface of Adaptee to the Target interface
            involves a single class which is responsible to join functionalites of independent or incompatible interfaces


Class Adapter implementation

    Multiple inheritance - not possible in java, But still can utilize interfaces

    There is only one, not an adapter and an adaptee

    A class adapter is very similar to an object adapter
        the class adapter will subclass the Target and the Adaptee
        the object adapter will use composition to pass requests to an Adaptee
        composition versus inheritance

    A class adapter works by creating a new class which subclasses publicly from an abstract class to define its interface
        subclasses privately from our existing class to access its implementation
        each wrapped method calls its associated, privately inherited method

    A class adapter adapts Adaptee to Target by committing to a concrete Adaptee class
        will not work when we want to adapt a class and all its subclasses

    A class adapter lets the Adapter override some of the Adaptee's behavior since Adapter is a subclass of Adaptee


