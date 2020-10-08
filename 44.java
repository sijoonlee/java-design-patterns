DECORATOR Design Pattern


Overview

    The decorator pattern will allow you to attach additional responsibilities to an object dynamically
        - allows a user to add new functionality to an existing object without altering its structure

    Decorators provide a flexible alternative to sub-classing for extending functionality

    The main priniciple of this pattern says that we cannot modify existing functionalities but can extend them

    The core concept applies when we want to add some specific functionalities to some specific object
        - instead of the whole class

    Decorator is used to modify the functionality of an object at runtime
        - Other instances of the same class will not be affected by this


Example

    Suppose you already own a house
        Need an additional floor
        But don't want to change the architecture of existing floors

    Many object-oriented user interface toolkits use decorators to add graphical additions to widgets
        You want to add properties like borders or behaviors like scrolling to any user interface component
        But don't want to change the core functionality of GUI

    Suppose we have a TextView object that displays texts
        By default, it has no scroll behaviors
        When needed, we can use ScorllDecorator to add them

    Java I.O. package
        BufferedInputStream and LineNumberInputStream both extend FilterInputStream
            - FilterInputStream acts as an abstract decorator class


Advantages and Drawbacks

    The biggest advantage of using this pattern is that we can add new functionality without disturbing existing objects

    More flexible than static inheritance
        - it can be added or removed at run-time

    Easy to add a property twice
        - to give a TextView a double border, simply attach two BorderDecorators
    
    We can code incrementally
        - We can start from a simple class
        - then add decorator objects one by one as needed
        - We do not need to consider every possible scenarios from the beginning

    One drawback 
        - large number of small classes might be hard to debug


When to use Decorator

    When you want to add responsibilities to individual objects dynamically

    When extension by sub-classing is impractical
        - sometimes a large number of independent extensions are possible 
           and would produce an explosion of subclasses to support every combination
        - or a class definition may be hidden or otherwise unavailable for sub-classing