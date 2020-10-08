SINGLETON - Double Checked Locking

This approach will use a synchronized block inside the if statement
with an additional check to ensure that only one instance of the sigleton class is created
; the synchronization check happens at most one time

https://www.geeksforgeeks.org/volatile-keyword-in-java/
* Volatile
For Java, “volatile” tells the compiler that the value of a variable must never be cached 
as its value may change outside of the scope of the program itself. 

* volatile vs synchronized:
Before we move on let’s take a look at two important features of locks and synchronization.
    Mutual Exclusion: It means that only one thread or process can 
                        execute a block of code (critical section) at a time.
    Visibility: It means that changes made by one thread to shared data are visible to other threads.

Java’s synchronized keyword guarantees both mutual exclusion and visibility. 
If we make the blocks of threads that modifies the value of shared variable synchronized 
only one thread can enter the block and changes made by it will be reflected in the main memory.
All other thread trying to enter the block at the same time will be blocked and put to sleep.

In some cases we may only desire the visibility and not atomicity. 
Use of synchronized in such situation is an overkill and may cause scalability problems. 
Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized 
but not the atomicity features. The values of volatile variable will never be cached 
and all writes and reads will be done to and from the main memory. 
However, use of volatile is limited to very restricted set of cases 
as most of the times atomicity is desired. 
For example a simple increment statement such as x = x + 1; or x++ seems to be a single operation 
but is s really a compound read-modify-write sequence of operations that must execute atomically.



public class Singleton {

    // the private reference to the one and only instance
    // volatile
    private volatile static Singleton uniqueInstance = null;

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
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {  // we only synchronize the first time through
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
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
