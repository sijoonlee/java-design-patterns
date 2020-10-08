import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private List<Item> items;

    public Vehicle(){
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.println(", Price : " + item.price());
        }
    }

}
