SINGLETON - Bill Pugh 

Using inner static helper class

This is the most widely used approach for the Singleton class
    it does not require synchronization
    it is easy to implement
    regarded as the standard method to implement singletons in JAVA


public class Singleton {

    // an instance attribute
    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */

    private Singleton() {}

    private static class SingletonHelper {
        // Nested Class is referenced after getInstance() is called
        private static final Singleton uniqueInstance = new Singleton();
    }

    public static Singleton getInstance()
    {
        return SingletonHelper.uniqueInstance;
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
