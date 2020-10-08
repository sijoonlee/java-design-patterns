BRIDGE DESIGN PATTERN

Decouples implementation class and abstract class by providing a bridge structure between them
    - Implementation: the objects that the abstract class and its derivations use to implement themselves

Abstraction and implementation can be extended independently
    - Allows you to vary the implementation and the abstraction by placing the two in separate class hierachies

Changes to the concreate abstraction classes do not affect the client

Adds one more method level redirection to achieve the objective

One drawback is that it does slightly increase complexity

Compared to the Adapter
    - the Adapter pattern is geared toward making unrelated classes work together
        - usually it is appllied to systems after they have been designed
    - In contrast, the Bridge is used up-front in a design
        - lets abstractions and implementations vary independently

Example
    - a software company consisting of two teams: dev team, tech-support team
        - a change in the operational strategy of one team should not have a direct impact on the other team
        - tech-support team plays the role of a bridge between the clients and the dev team that implements the product
    - GUI framework
        - separate window abstraction from window implementation


Composition/Aggregation over Inheritance

    When an abstraction can have one of several possible implementations, usually inheritance will be used to accomodate this
    An abstract class defines the interface to the abstraction, and concrete subclasses implement it in different ways
    Inheritance binds an implementation to the abstraction permanently - not flexible
    -> The bridge pattern is an excellent example to overcome this rigidity


Participants in detail

    Abstraction
        - core of the bridge design pattern and defines the crux
        - defines the abstraction's interface
        - contains a reference to the implementer
    RefinedAbstraction
        - extends the abstraction takes the finer detail one level below
        - hides the finer elements from implementers
    Implementer
        - defines the interface for implementation classes
        - provides an implementation in terms of operations provided by implementer interface
    Concrete Implementer
        - Implements the above implementer by providing concrete implementation


High Level Design Example

    TV & Remote
    - Your dilemma is that the remotes are subject to be changed, and the TVs are, too.
    - You have already abstracted the user interfact of Remote; you can vary the implementation over the many TVs
    - You are also going to need to vary the abstraction
    - With current design, we can vary only the TV implementation, not the user interface
    - The Bridge pattern will allow you to vary the implementation and the abstraction

    Abstraction Calss Hierachy
        RemoteControl(hasA reference to implementor(TV)) - on(), off(), setChannnel()
        ConcreteRemote: inherit RemoteControl - on(), off(), setChannel(), nextChannel(), previousChannel()

    Implementation Class Hierachy
        TV: on(), off(), tuneChannel()
        RCA: inherit TV - on(), off(), tuneChannel()
        Sony: inherit TV - on(), off(), tuneCHannel()

    RemoteControl hierachy <-Bridge-> TV hierachy 
    - Both hierachies can grow independently
    - If we make any change in abstraction methods, they don't have any impact on the implementer method

    The abstraction and implementer do not need to be an abstract classes - can be interfaces

    You can change the implementers dynamically at runtime by changing the reference in the abstraction
    



