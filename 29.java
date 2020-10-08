Implementation

Participants
    Prototype : declares an interface for cloning itself
    ConcretePrototype : implements an operation for cloning itself
    Client : creates a new object by asking a prototype to clone itself

How to implement
    1) implement Java Cloneable interface
    2) define clone() method that should handle CloneNotSupportedException
        - returns a shallow copy of the object
            if copied object contains reference to the other objects,
            these objects are not cloned; deep copy will do
    3) call superclass's clone() method


Example

class Person implements Cloneable { // step 1
    private String name;
    private City city; // deep copy

    // no override
    public person clone() throw CloneNotSupportedException { // step 2
        Person clonedObj = (Person) super.clone(); // step 3
        
        // if you need deep copy
        cloneObj.city = this.city.clone(); // making deep copy of city
        
        return cloneObj;
    }
}


Problems with the Clonable interface

the Cloneable interface lacks the clone() method
    Cloneable is a marker interface and doesn't have any methods
    Still it is needed to implement to tell JVM that we can perform clone()

Object.clone() is protected
    we have to provide our own clone() method and call Object.clone() indirectly from it

We don't have control over object construction 
because Object.clone() doesn't invoke any constructor
    there are no guarantees that it preserves the invariants established by the constructors

if we want to have a clone method in a child class
then all superclasses should define clone() method
    super.clone() chain

Object.clone() supports only shallow copy
    doesnt' clone the reference fields of the object to be cloned
    we need to implement clone() in every class whose reference our class is holding
    - if you need deep copy, the object to be copied should have clone() method in it

We cannot manipulate final field in Object.clone()
    final fields can only be changed through constructors
    Object.clone() will not call the constructor
        - final field cannot be modified from invoking the clone method
        ex) when we want every objects to have unique final id

You cannot do a polymorphic clone operation
    if I have an array of Cloneable, you would think I could run down the array
    and clone every element to make a deep copy of the array
        - but it doesn't ; you cannot cast something to Cloneable and call the clone
        - Cloneable doesn't have public clone method, neither does Object

The clone generally shares state with the object being cloned
    if you modify one, the other changes as well


Alternatives to using Cloneable - Copy Constructor
    inside of the consturctor, custom cloning logic is implemented
    overcome every design issue of Object.clone()

Copy Constructor Example
    
public Person(Person Original){
    this.id = original.id + 1; 
    this.name = new String(original.name);
    this.city = new City(original.city);
}


Alternatives to using Cloneable - Serialization

    you can serialize an object and then immediately deserialize it
    - it would result in an new instance created
    still not be able to modify the final field
    still don't have any control over constructor
    still need to implement Serializable interface
    the serialization is slower than Object.clone()

Serialize/Deserialize Example

public Person copy(Person original){
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj")))
    {
        out.writeObject(original);
        return (Person) in.readObject();
    }
    catch(Exception e)
    {
        throw new RuntimeException(e);
    }

}


-------------------------------------------------------------------

abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    // no override!!
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}

class Square extends Shape {
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

--------------------------------------------------------------------------------

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}

-----------------------------------------------------------------------------

public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}