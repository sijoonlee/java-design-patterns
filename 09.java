DEPENDENCY INVERSION

    Entities must depend on abstractions and not on concretions
        the goal is to reduce dependencies on concrete classes
    
    Abstractions should not depend upon details
        details should depend upon abstractions

    High level classes must not depend on the low level classes
        both high-level classes and low-level classes should depend upon abstractions
        the low-level class implementation is accessible 
            to the higher-level class via an abstract interface
        actual implementation of lower level class can then vary

    The "inversion" is there because it inverts the way you typically might think about
        your OO design
        top-to-bottom dependency has inverted itself, 
            with both high-level and low-level classes now depending on an abstraction
    
    Removes tight coupling that comes with a top-down design approach
        - easier to maintain and extend the overall system

    Introduces a layer of abstrction between each higher level class and
        low level concrete class
            - high-level classes depend only on a common abstraction
            - low-level classes can then be modified or extended without
                disturbing high-level classes

    Guideline
        - no variable should hole a reference to a concrete class (factory design)
        - no class should subclass from a concrete class (only from an interace or abstract class)
        - no method should override an implemented method of any of its base classes
        - if a class is unlikely to change, it's ok to instantiate a concrete class (ex String class)
    
    Pizza Store Example
        
        we could approach from top to down
            e.g. pizza store, and then its specific pizzas
            pizza store will be dependent on the concrete pizza types
        let's invert the way of approach
            e.g. let pizza be abstraction
            the concrete pizza types depend only on an abstraction
            and so does the store
        
        Pizza (abstraction)

        PizzaStore (high-level class)
            - its behaviour is defined in terms of pizzas
            - it creates all the different pizza objects
            - it prepares, bakes, cuts and boxes pizzas
        
        Each pizza (low-level classes)
            - VeggiePizza
            - NYStyle
            - ChicagoStyle

        PizzaStore class is independent on the concrete pizza classes
        PizzaStore and the concrete pizzas depend on Pizza class(abstraction)


Before

// high level class is dependent on low level class
class PasswordReminder{ //high level class
    private int dbConnection;
    public PasswordReminder(MySqlConnection dbConnection){ 
        //MySqlConnection : low level class
        this.dbConnection = dbConnection;
    }
}


After

interface DBConnectionInterface {
    public int connect();
}

class MySqlConnection implements DBConnectionInterface
{
    public int connect(){
        return 1;
    }
}

class PasswordReminder { // high level
    private DBConnectionInterface dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection)
    {
        this.dbConnection = dbConnection;
    }
}