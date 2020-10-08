FACTORY METHOD

Factories handle the details of object creation
    creates objects without exposing the creation logic to the client(Creator)
    and refers to the newly created object using a common interface(Product)

Defines an interface for creating an object (Creator)

When a class needs to instantiate a subclass of another class,
but doesn't know which one
    it lets subclasses decide which class to instantiate

Used in frameworks
    frameworks use abstract classes to define and maintain relationships between objects
    often responsible for creating these objects as well

Framework should not know and should not be concerned about instantiating specific objects
    need to defer the decisions about specific obejcts to the users of the frameworks

use the Factory Method patter When
    - a class cannot anticipate the class of objects it must create
    - a class wants its subclasses to specify the objects it creates
    - implementing parallel class hierachies
        when some of the responsibilities shift from one class to another

Examples
    in JDK, 
        java.util.Calendar, ResourceBundle, NumberFormat
        getInstance() methods

    valueOf() method in wrapper classes like Boolean, Integer etc

    SAXParserFactory
        a factory class which can be used to intantiate SAX based parsers to parse XML
        method newInstance is the factory method which instantiates the sax parsers
            based on some predefined logic
    
Advantages
    decouples the business logic of creation of a class from
        the actual logic of the class
    You can add additional products or change a product's implementation
        and it will not affect your Creator
    Creator is not tightly coupled to any ConcreteProduct
    Provides abstraction between implementation and client classes through inheritance

Disadvantages
    clients might have to subclass the Creator class just to cretae a particular
        ConcreteProduct object
    The client now must deal with another point of evolution
    Makes code more difficult to read as all of your code is behind an abstraction
    



