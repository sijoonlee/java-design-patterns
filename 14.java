FACTORY METHOD IMPLEMENTATION - CONCRETE CREATOR

Single concrete creator class
    - the creator class is concrete class
    - you add implementation code to one factory method to create your product type
      based on a parameter passed to the method
    - to use the factory method(create objects), you create an instance of the creator class
      and invoke the factory method with an argument for your "class type"

The advantage of this approach is that you do not need to create a new subclass of
    the abstract creator class and implement a new facotry method



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

----------------------------------------------------------------

public class ShapeFactory {

    // use getShape method to get object of type shape
    public Shape getShape(String shapeType) {
        if (shapeType == null)
            return null;
        else if (shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle();
        else if (shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        else if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square();

        return null;
    }
}

----------------------------------------------------------------

public class Client {
    public static void main(String [] args)
    {
       ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }
}