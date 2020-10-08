Builder Example


interface MealBuilderInterface {
    void buildBurger();
    void buildDrink();
    Meal getMeal();
}

class VegMealBuilder implements MealBuilderInterface
{
    private Meal vegMeal = new Meal();

    @Override
    public void buildBurger(){
        vegMeal.addItem(new VegBurger());
    }

    @Override
    public void buildDrink() {
        vegMeal.addItem(new Coke());
    }

    @Override
    public Meal getMeal() {
        return vegMeal;
    }
}

class NonVegMealBuilder implements MealBuilderInterface {
    private Meal nonVegMeal = new Meal();

    @Override
    public void buildBurger(){
        nonVegMeal.addItem(new ChickenBurger());
    }

    @Override
    public void buildDrink() {
        nonVegMeal.addItem(new Pepsi());
    }

    @Override
    public Meal getMeal() {
        return nonVegMeal;
    }

}

-----------------------------------------------------------------

package academy.learnprogramming;

import academy.learnprogramming.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items;

    public Meal() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}

----------------------------------------------------------------

package academy.learnprogramming;

interface Item {
    public String name();
    public Packing packing();
    public float price();
}

abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

class VegBurger extends Burger {

    @Override
    public float price() {
        return 3.50f;
    }

    @Override
    public String name()
    {
        return "Veg Burger";
    }
}

class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 4.50f;
    }

    @Override
    public String name()
    {
        return "Chicken Burger";
    }
}

abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 1.50f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

class Coke extends ColdDrink {
    @Override
    public float price() {
        return 1.75f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}

interface Packing {
    public String pack();
}

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

-----------------------------------------------------------

package academy.learnprogramming;

class Director {
    MealBuilderInterface myBuilder;

    public void construct(MealBuilderInterface builder) {
        myBuilder = builder;
        myBuilder.buildBurger();
        myBuilder.buildDrink();
    }
}
---------------------------------------------------------------

package academy.learnprogramming;

public class Client {
    public static void main(String[] args) {
        System.out.println("***Meal Pattern Demo***\n");

        Director director = new Director();

        MealBuilderInterface vegMealBuilder = new VegMealBuilder();
        MealBuilderInterface nonVegMealBuilder = new NonVegMealBuilder();

        // making veg meal
        director.construct(vegMealBuilder);
        Meal vegMeal = vegMealBuilder.getMeal();

        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        // making non veg meal
        director.construct(nonVegMealBuilder);
        Meal nonVegMeal = nonVegMealBuilder.getMeal();

        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
