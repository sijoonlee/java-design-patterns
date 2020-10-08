COMPOSITE DESIGN PATTERN

    It composes objects into tree structures to represent part-whole hierachies
        - lets clients treat individual objects and compositions of objects uniformly

    A composite is an object designed as a composition of one-or-more similar objects that all exhibit similar functionality
        - Objects in the same group are treated as the same way a single instance is treated

    When we have many objects with common functionalities, we create a composite object

    The main purpose of the composite is to allow you to manipulate a single instance of the object just as you would manipulate a group of them



Example

    An organization that has many departments
        - all are employess of the organization
        - groups of employess could create a departments
        - those departments can be grouped together to build the whole organization

    Graphics application - drawing editors
        - let users build complex diagrams out of simple components
        - user can group components to form larger components

    Menu GUI
        - menus and items in the same structure -> part-whole hierachy
        - a tree of objects is made of parts
        - tree structure of menus, submenus, menu items 
        - any menu is a composition, since it contain both other menus and menu items
        - can be treated as a whole
        


When we use composite design pattern

    When clients need to ignore the difference between compositions of objects and individual objects
    - multiple objects with nearly identical code

    Have to reduce memory usage
    - less number of objects

    Efficiency is matter
    - reduce the execution time by sharing objects

    Forced to maintain child ordering
    - parse trees as components


Benefit & Drawback

    Easy to add new kinds of components

    makes clients simpler

    Hard to restirct the type of components 
    - cannot rely on the type system to enforece constraints
    - have to use run-time checks
