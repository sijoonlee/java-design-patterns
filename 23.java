SINGLETON - Eager Evaluation

In eager evaluation, the instance of Singleton class is created at the time of class loading
    Easiest method to create a singleton class
    It has a drawback that the instance is created even when it is unnessary

JVM guarantees that the instance will be created before any thread accesses the static uniqueInstance variable


Problem
    if the singleton class uses lots of resources, the eager initalization is not the approach
    For file system, database connection, we should avoid the instantiation until client calls the getInstance method


public class Singleton {

    // the private reference to the one and only instance
    private static Singleton uniqueInstance = new Singleton(); // instantiation

    // an instance attribute
    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */

    private Singleton() {}

    public static Singleton getInstance()
    {
        // we already got an instance
        return uniqueInstance;
    }

    public void setData(int myData) {
        data = myData;
    }

    public int getData() {
        return data;
    }
}

public class TestSingleton {
    public static void main(String [] args) {

        Singleton s = Singleton.getInstance();

        // set the data value
        s.setData(55);

        System.out.println("First reference: " + s);
        System.out.println("Singleton data value is: " + s.getData());

        // Get another reference to the Singleton.
        // Is it the same object?

        s = null;
        s = Singleton.getInstance();

        System.out.println("\nSecond reference: " + s);
        System.out.println("Singleton data value is: " + s.getData());
    }
}