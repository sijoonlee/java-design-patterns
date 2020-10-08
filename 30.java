import java.util.Random;

abstract class BasicCar implements Cloneable {
    protected String modelName;
    public int price;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setPrice() {
        int price = 0;
        Random r = new Random();
        int p = r.nextInt(100000);
        price = p;
        return price;
    }

    public BasicCar clone() {
        BasicCar clone = null;
        try {
            clone = (BasicCar)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Ford extends BasicCar implements Cloneable {

    public Ford (String m)
    {
        modelName = m;
    }

    @Override
    public Ford clone()
    {
        Ford clone = null;
        clone = (Ford) super.clone();
        return clone;
    }
}

class Nano extends BasicCar implements Cloneable {

    public Nano(String m)
    {
        modelName = m;
    }

    @Override
    public Nano clone()
    {
        Nano clone = null;
        clone = (Nano) super.clone();
        return clone;
    }
}

---------------------------------------------------------------

import java.util.Hashtable;

public class BasicCarCache {
    private static Hashtable<String, BasicCar> basicCarMap = new Hashtable<String, BasicCar>();

    public static BasicCar getCar(String carName) {
        BasicCar cachedBasicCar = basicCarMap.get(carName);
        return (BasicCar) cachedBasicCar.clone();
    }

    public static void loadCache() {
        BasicCar nano_base = new Nano("Green Nano");
        nano_base.price=100000;
        basicCarMap.put("Green Nano", nano_base);

        BasicCar ford_basic = new Ford("Ford Yellow");
        ford_basic.price=500000;
        basicCarMap.put("Ford Yellow", ford_basic);
    }
}

---------------------------------------------------------

public class Client {

    public static void main (String []args) {
        System.out.println("***Prototype Pattern Demo***\n");

        BasicCarCache.loadCache();

        BasicCar bc1 = (BasicCar ) BasicCarCache.getCar("Green Nano");

        //Price will be more than 100000 for sure
        bc1.price = bc1.price+BasicCar.setPrice();
        System.out.println("Car is: "+ bc1.getModelName()+" and it’s price is Rs."+bc1.price);

        bc1 = (BasicCar ) BasicCarCache.getCar("Ford Yellow");

        //Price will be more than 500000 for sure
        bc1.price = bc1.price+BasicCar.setPrice();
        System.out.println("Car is: "+ bc1.getModelName()+" and it’s price is Rs."+bc1.price);
    }
}