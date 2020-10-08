Builder Pattern Example


interface BuilderInterface {
    void buildBody();
    void insertWheels();
    void addHeadlights();
    Product getVehicle();
}

class Car implements BuilderInterface {
    private Product product = new Product();

    @Override
    public void buildBody() {
        product.add("This is a body of a car");
    }

    @Override
    public void insertWheels() {
        product.add("4 wheels are added");
    }

    @Override
    public void addHeadlights() {
        product.add("2 headlights are added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}

class MotorCycle implements BuilderInterface
{
    private Product product = new Product();

    @Override
    public void buildBody() {
        product.add("This is a body of a Motorcycle");
    }

    @Override
    public void insertWheels() {
        product.add("2 wheels are added");
    }

    @Override
    public void addHeadlights()  {
        product.add("1 Headlight has been added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}

------------------------------------------------------------------------------------------

import BuilderInterface;

public class Director {
    BuilderInterface myBuilder;

    public void construct(BuilderInterface builder) {
        myBuilder = builder;
        myBuilder.buildBody();
        myBuilder.insertWheels();
        myBuilder.addHeadlights();
    }
}

-------------------------------------------------------------------------------------------

import java.util.LinkedList;

public class Product {
    private LinkedList<String> parts;

    public Product () {
        parts = new LinkedList<String>();
    }

    public void add(String part) {
        parts.addLast(part);
    }
    // The java.util.LinkedList.addLast() method in Java is used to 
    // insert a specific element at the end of a LinkedList.
    // Syntax:
    // void addLast(Object element)

    public void show() {
        System.out.println("\n Product completed as below");

        for(int i = 0; i < parts.size(); i++)
            System.out.println(parts.get(i));
    }
}

-----------------------------------------------------------------------------------------------------------

public class Client {
    public static void main(String [] args) {
        System.out.println("***Builder Pattern Demo***\n");

        Director director = new Director();

        BuilderInterface carBuilder = new Car();
        BuilderInterface motorBuilder = new MotorCycle();

        // making a car
        director.construct(carBuilder);
        Product p1 = carBuilder.getVehicle();
        p1.show();

        // making a motorcycle
        director.construct(motorBuilder);
        Product p2 = motorBuilder.getVehicle();
        p2.show();
    }
}