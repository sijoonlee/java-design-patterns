FACTORY METHOD IMPLEMENTATION - STATIC METHOD

Define a factory as static method

Sometimes used so that you do not need to instantiate an object
    to make use of the create method

This technique has the disadvantage that you cannot subclass
    and change the behaviour of the create method



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

------------------------------------------------------------

public class ShapeFactory {

    //use getShape method to get object of type shape
    public static Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

}

------------------------------------------------------------

public class Client {

    public static void main(String[] args) {
        //get an object of Circle and call its draw method.
        Shape shape1 = ShapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = ShapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = ShapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }
}