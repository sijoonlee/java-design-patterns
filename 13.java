FACTORY METHOD IMPLEMENTATION - ABSTRACT CREATOR

Abstract creator is the strictest one 
among 3 common implementations of the factory method pattern
- the creator class is an abstract class
- you create a subclass of the creator class for each product type 
  which contains an implementation of the factory method
- to use the factory method(create objects), you simply specify an instance
  of that type and invoke the factory method

the disadvantage of this approach is that every new product has to
subclass the creator class and implement its factory method

Product : the interface for the type of object that Factory method creates

Creator : the interface that defines the Factory method
  - any other methods implemented here are written to operate on 
    products produced by the factory method
  - the creator class is written without knowledge of the actual products
    that will be created

Clients will need to subclass the Creator class to make a particular concrete product
  - only subclasses actually implement the factory method and create products

The actual products that will be created is decided 
    purely by the choice of the subclass that is used



interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

-------------------------------------------------------

public abstract class AbstractShapeFactory {

    protected abstract Shape factoryMethod();

    public Shape getShape() {
        return factoryMethod();
    }

    // other helper methods
}

class RectangleFactory extends AbstractShapeFactory
{
    protected Shape factoryMethod()
    {
        return new Rectangle();
    }
}
class SquareFactory extends AbstractShapeFactory
{
    protected Shape factoryMethod()
    {
        return new Square();
    }
}

class CircleFactory extends AbstractShapeFactory
{
    protected Shape factoryMethod()
    {
        return new Circle();
    }
}

------------------------------------------------------

public class Client {
    public static void main(String[] args) {
        //get an object of Circle and call its draw method.
        Shape shape1 = new CircleFactory().getShape();
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = new RectangleFactory().getShape();

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = new SquareFactory().getShape();

        //call draw method of square
        shape3.draw();


    }
}
