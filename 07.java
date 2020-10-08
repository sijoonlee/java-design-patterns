LISKOV SUBSTITUTION PRINCIPLE

    Barbara Liskov introduced

    The principle defines that objects of a superclass can be replaceable 
        with objects of its subclasses without breaking the application
        - requires the obejects of your subclasses to behave 
          in the same way as the objects of your superclass
        - methods which use a superclass type must be able to work with
          the subclass without any issues
        
    An overrideen method of a subclass needs to accept the same input parameter
        values as the method of the superclass
        - do not implement any stricter validation rules on input parameters than
          implemented by the parent class
        - any code that calls this method on an object of the superclass might
          cause an exception, if it gets called with an object of the subclass
        
    The return value of a method of the subclass needs to comply with the same
        rules as the return value of the method of the superclass
        - you can only decide to apply stricter rules by returning a specific
          subclass of the defined return value or by returning a subset of the
          valid return values of the superclass
        
    In order to follwo LSP the subclass must enhance functionality

    This principle is in line with what Java also allows
        - a superclass reference can hold a subclass object
        - superclass can be replaced by subclass in a superclass reference at any time
        - the Java inheritance mechanism follows the Liskov Substitution Principle

    LSP is closely related to the Single responsibility principle 
        and Interface Segregation Principle
        - if a base class has more functionality than a subclass might not support
          support some of the functionality and does violate LSP

    This principle extends the Open/Closed Principle
        the Open/Closed Principle says that a class should be open for the extension 
        and closed for modification
        - we override the original class and implement the functionality to be changed
          in the overriding class
        - when the subclass object is used in place of the superclass the overridden
          functionality is executed
        - this is exactly in line with the Liskov Substitution Principle



abstract class Vehicle {
    abstract int getSpeed();
    abstract int getCubicCapacity();

    public static void main (String [] args) {
        Vehicle vehicle = new Bus();
        vehicle.getSpeed();
        vehicle = new Car();
        vehicle.getCubicCapacity();
    }
}

class Car extends Vehicle {
    int getSpeed() { return 0;}
    int getCubicCapacity() { return 0;}
    boolean sHatchBack() { return true; }
}

class Bus extends Vehicle{
    int getSpeed() { return 0;}
    int getCubicCapacity() { return 0;}
    String getEmergencyExitLoc() { return "";}
}