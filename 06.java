OPEN CLOSED PRINCIPLE

    Bertrand Meyer proposed
        classes and methods should be Open for extension and Closed for modification
        class should be easily extensible without modifying the class itself

    Rober C. Martin considered this principle as "the most important principle 
        of object-oriented design"

    A module is said to be open if it is still available for extension
        it should be possible to add fields to the data structures it contains
        or new elements to the set of functions it performs
    
    A module is said to be closed if it is available for use by other modules
        assumes that the module has been given a well-defined, stable description
        the interface in the sense of information hiding (not a java interface)

    General idea of this principle is to enable you to add new functionality 
        without changing the existing code
        - prevents situations in which a change to one of your classes also
            requires you to adapt all depending classes
        - reduce tight coupling
    
    Unfortunately, Bertrand Mayer proposed the use of inheritnace to achieve the open/closed principle

    However, inheritance introduces tight coupling if the subclasses depend on 
        implementation details of their parent class
    
    Others redefined the Open/Closed Principle to the Polymorphic Open/Closed Principle

    Interfaces are closed for modifications
        - you can provide new implementations to extend the fucntionality of your software
        - new implementations must implement the interface
    
    Interfaces introduce an additional level of abstraction which enables loose coupling
        interfaces are independent of each other and do not need to share any code(usually)


------ Before ------

class Rectangle{
    public double length;
    public double width;
}
class Circle{
    public double radius;
}
class AreaCalculator{
    public double calculateRectangleArea(Rectangle rectangle){
        return rectangel.length * rectangle.width;
    }

    public double calculateCircleArea(Circle circle){
        return (22/7) * circle.radius * circle.radius;
    }
}

------ After ------
public interface Shape {
    public double calculateArea();
}

class Rectangle implements Shape {
    public double length;
    public double width;

    public double calculateArea()
    {
        return length * width;
    }
}

class Circle implements Shape {
    public double radius;

    public double calculateArea(){
        return (22/7) * radius * radius;
    }
}

class AreaCalculator {
    public double calculateShapeArea(Shape shape) {
        return shape.calculateArea(); // looks delegation
    }
} // more shapes can be added without changing existing codes
