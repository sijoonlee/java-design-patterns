Singleton - Lazy Evaluation

problem - not thread safe

    suppose two calls to getInstance() are made at virtually the same time

    the first therad checks to see whether the instance exists
        if not, it will create the first instance
    
    however, before it has been done (instance is still is equal to null), 
    suppose the second thread also looks to see whether the instance member is null

    both threads now create their own objects, two in total




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

    public static Singleton getInstance()
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