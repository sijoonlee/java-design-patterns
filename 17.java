ABSTRACT FACTORY METHOD

Abstract factory provides an interface for creating families of related or dependent objects
without specifying their concrete classes
    "factory of factories", super factory

The methods of an abstract factory are implemented as factory methods
    provides an encapsulation mechanism to a group of individual factories
    factory method is a subset of this pattern

There is often one concrete class implemented for each family

When we need to deal with multiple factories

When the problem domain has different families of objects present
and each family is used under different contexts

When a family of related product objects is designed to be used together,
and you need to enforce this constraint

When you want to provide a class library of products,
and you want to reveal just their interfaces, not their implementations

Product class names are isolated in the implementation of the concrete factory
they do not appear in client code

Makes exchanging product families easy
    the class of a concrete factory appears only once in an application
    ; where it is instantiated
    makes it easy to change the concrete factory as application uses

Can support a complete family of products
    enforces the use of products only from one family

Promotes consistency among products

Supporting new kinds of products is difficult
    need to extend the interface, 
    consquently, changes are required in all subclasses that the interface applies

Relation to factory method
    Abstrct factory delegates the responsibility of object instantiation
        to another object via [composition]
        - provides an abstract type for creating a familty of products (get "right" factory)
        - subclasses of this type define how those products are produced (the actual factory method)
        - interface has to change if new products are added
    Factory Method uses [inheritance] and relies on a subclass to handle the desired object instantiation
        - usually implement code in the abstract creator that makes use of the concrete types the subclasses create
    Use the abstract factory whenever you have families of products you need to create
        - make sure your clients create products that belong together
    Use the factory method when you want to decouple your client code from the concrete classes
        - just subclass it and implement its factory method

Tips for implementation
    an application typically needs only one instance of a concrete factory per product family
        - usually best implemented as a Singleton
    AbstractFactory only declares an interface for creating products
        - up to ConcreteProduct subclasses to actually create them (just like in the factory method)
        - most common way to do this is to define a factory method for each product
        - concrete factory will specify its products by overriding the factory method for each
        - requires a new concrete factory subclass for each product family,
          even if the product families differ only slightly
    If many product families are possible, the concrete factory can be implemented using
    the Prototype pattern
        - concrete factory is initialized with a prototypical instance of each product in the family
          and it creates a new product by cloning its Prototype
        - eliminates the need for a new concrete factory class for each new product family


public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType)
    {
        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }

    @Override
    Color getColor(String color)
    {
        return null;
    }

}

class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    Color getColor(String color) {

        if(color == null){
            return null;
        }

        if(color.equalsIgnoreCase("RED")){
            return new Red();

        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();

        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }

        return null;
    }
}


public class FactoryProducer {
    public static AbstractFactory getFactory(String choice)
    {

        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();

        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }

        return null;
    }

}

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

interface Color {
    void fill();
}

class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}


public class Client {
    public static void main(String [] args)
    {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        //get an object of Shape Square
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape3.draw();

        //get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Color color1 = colorFactory.getColor("RED");

        //call fill method of Red
        color1.fill();

        //get an object of Color Green
        Color color2 = colorFactory.getColor("Green");

        //call fill method of Green
        color2.fill();

        //get an object of Color Blue
        Color color3 = colorFactory.getColor("BLUE");

        //call fill method of Color Blue
        color3.fill();
    }
}