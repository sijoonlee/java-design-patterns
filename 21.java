SINGLETON - Synchronized method

Problem
    The synchronization may end up being a severe bottleneck
    ; all the threads will have to wait for the check on whether the object already exists
    
    The only time synchronization is relevant is the first time through this method
    ; the first time is when checking whether uniqueInstance is null before we have the instance
    ; once we have set the uniqueInstance variable to an instance of Singleton,
        we have no futher need to synchronize this method
    ; after the first time, synchronization is totally unneeded overhead




public class Singleton {

    // the private reference to the one and only instance
    private static Singleton uniqueInstance = null;

    // an instance attribute
    private int data = 0;

    /**
     * The Singleton Constructor
     * Note that it is private!
     * No client can instantiate a Singleton object!
     */

    private Singleton() {}

    // by adding the synchronized keyword to getInstance(),
    // we force every thread to wait its turn before it can enter the method
    public static synchronized Singleton getInstance()
    {
        if (uniqueInstance == null)
            uniqueInstance = new Singleton();

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
