PROTOTYPE DESIGN PATTERN

Prototype pattern referes to creating a duplicate object while keeping performance in mind
    specifies the kinds of objects to create using a prototypical instance, 
    and creates new objects by copying this prototype

Used when creation of an object is costly, and you have a similar object existing

Provides a mechanism to copy the original object to a new object and then modify it
    uses java cloning to copy the object(shallow)
    use de-serialization when you need deep copy

A key aspect of this pattern is that the client code can make new instances 
    without knowing which specific class is being instantiated

Mandates that the object which you are copying should provide the copying feature
    should not be done by any other class
    whether to perform a shallow or deep copy of the object depends on the need


When is it needed?
    dynamic loading (instantiate classes at runtime)
    many types of new objects from a complex class hierachy
        - factory method often produces a hierachy of Creator classes that paralles the product class hierachy
        - prototype pattern lets you clone a prototype instead of asking a factory method to make a new object
        - prototype pattern doesn't need a Creator class hierachy at all ( reduces subclassing )

    instances of class can have only few different states
        - might be convenient to install a corresponding number of prototypes


Examples

    Suppose an application
        we want to create a similar application with small changes
        start with a copy from our master copy application and make the changes

    Suppose an Object that loads data from database
        we need to modify this data mulitiple times
            not a good idea to create object using new keyword and load data all over again from database
        we can cache the object, return a clone of the object on requests
            reduces the number of database calls


Drawbacks

    Each subclass has to implement the cloning meachanism
    Implementing the cloning mechanism can be challenging
        - the objects might not support copying
        - circular reference
    The java cloneable interface has some problems



