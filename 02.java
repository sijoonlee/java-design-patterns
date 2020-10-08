
PROGRAM TO AN INTERFACE

1. Interface could be the concept of interface or Java construct interface
    you can program to an interface without having to actually use a Java interface

2. "Program to an interface" really means "Program to a supertype"
    the declared type of the variables should be a supertype, usually an abstract class or interface
    the objects assigned to those variables can be of any concrete implementation of the supertype
    the class declaring them doesn't have to know about the actual object types

3. Do not declare variables to be instances of a particular concrete class
    instead, commit only to an interface defined by an abstract class(interface or abstract)

4. Always program for the interface and not for the implementation
    will lead to flexible code which can work with any new implementation of the interface

5. Programming to an interface is a common theme of the design patterns

6. Manipulating objects solely in terms of the interface is beneficial to clients
    Clients do not need to know the specific types of objects they use
    ; As long as the objects adhere to the interface that clients expect
    Clients do not need to know the classes that implement these objects
    ; they only know about the abstract class(es) defining the inferface

7. "Programming to an interface" greatly reduces implementation dependencies between subsystems

8. We can use interface types on variables, return types of methods or parameter types in a method

9. The point is to exploit polymorphism by programming to a supertype so that the actual runtime object
    is not locked into the code


Example
    Programming to an interface/supertype would be:
        Animal animal = new Dog();
        animal.makeSound();
    ; We can use the animal reference polymorphically

    Even better, rather than hardcoding the instantiation of the subtype(like new Dog()),
    assign the concrete implementation object at runtime:
        a = getAnimal();
        a.makeSoud();
    
    We don't know WHAT the actual animal subtype is
    ; all we care about is that it knows how to respond to makeSound()


Abstract Classes vs. Interface
    
    variables
        - interface: public static final
        - abstract classes: private, protected, etc

    methods
        - interface: public or public static
        - abstract classes: private, protected
    
    utilize abstract classes to establish a relationship between interrelated objects
        - when you want to share code among several closely related classes
        then this common state or behavior can be put in the abstract class

    utilize interafaces to establish a relationship between unrelated classes
        - the interface Comparable and Cloneable are implemented by many unrelated classes
    
    utilize interfaces if you want to specifiy the behavior of a particular data type,
    but are not concerned about who implements its behavior

    utilize interfaces if you want to take advantage of multiple inheritance

    you might create an interface and then have an abstract class implement that interface


interface displayModule {
    public void display();
}

class Monitor implements displayModule {
    public void display()
    {
        System.out.println("Display through Monitor");
    }
}

class Project implements displayModule {
    public void display()
    {
        System.out.println("Display through projector");
    }
}

public class Computer {
    displayModule dm;

    public void setDisplayModule(displayModule dm)
    {
        this.dm=dm;
    }

    public void display()
    {
        dm.display();
    }

    public static void main(String args[])
    {
        Computer cm = new Computer();
        displayModule dm = new Monitor();
        displayModule dm1 = new Project();

        cm. setDisplayModule(dm);
        cm. display();
        cm. setDisplayModule(dm1);
        cm. display();
    }
}

