INTERFACE SEGREGATION PRINCIPLE

    Robert C. Martin

    "Client should not be forced to depend upon interfaces that they do not use"
        a client should not implement an interface 
            if it does not use a method in that interface
        happens mostly when one interface contains more than one functionality, 
            and the client only needs one functionality and not the other
    
    The goal is to reduce the side effects and frequency of required changes by
        splitting the software into multiple, independent parts

    Interface design is a triky job because once you release your interface
        you can not change it without breaking all implementation
    
    using the interface keyword in java means that you have to implement
        of the methonds in the interface before any class can use it
    
    if you follow this principle in java, you will implement less methods
        because each interface will have a single functionality
    
    a lean interface does not mean one method per interface

    a lean interface caters to a consumers of a specific type of functionality 
        or a specific set of customers all of whom have the same functional needs

    
Before

public interface ShapeInterface {
    public double area();
    public double volume();
}


After

public interface ShapeInterface {
    public double area();
}

interface SolidShapeInterface {
    public double volume();
}

interface ManageShapeInterface {
    public double calculate();
}

class Cube implements ShapeInterface, SolidShapeInterface, ManageShapeInterface {

    public double area() {
        // calculate the surface area of the cuboid
        return 1.0;
    }

    public double volume() {
        // calculate the volume of the cuboid
        return 1.0;
    }

    public double calculate() {
        return this.area() + this.volume();
    }
}

class Square implements ShapeInterface, ManageShapeInterface {
    public double area() {
        return 2.0;
    }

    public double calculate() {
        return this.area();
    }
}

Another Example

// fat interface
public interface RestaurantInterface {
    public  void acceptOnlineOrder();
    public  void takeTelephoneOrder();
    public  void payOnline();
    public  void walkInCustomerOrder();
    public  void payInPerson();
}

class OnlineClientImpl implements RestaurantInterface
{
    @Override
    public void acceptOnlineOrder() {
        //logic for placing online order
    }
    @Override
    public void takeTelephoneOrder() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }
    @Override
    public void payOnline() {
        //logic for paying online
    }

    @Override
    public void walkInCustomerOrder() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }

    @Override
    public void payInPerson() {
        //Not Applicable for Online Order
        throw new UnsupportedOperationException();
    }
}