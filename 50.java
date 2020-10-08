
interface Menus {
    void showMenu();
}

class NonVegMenu implements Menus {

    NonVegMenu()
    {
        System.out.println("Creating a non veg menu");
    }

    public void showMenu() {
        System.out.println("Menu items in non veg menu");
    }
}

class VegMenu implements Menus {

    VegMenu()
    {
        System.out.println("Creating a veg Menu menu");
    }

    public void showMenu() {
        System.out.println("Menu items in veg menu");
    }
}

class Both implements Menus {

    Both()
    {
        System.out.println("Creating both a non and veg menu");
    }

    public void showMenu() {
        System.out.println("Menu items in both a veg and non menu");
    }
}

-----------------------------------------------

public interface Hotel {
    public Menus getMenus();
}

class NonVegRestaurant implements Hotel
{
    public Menus getMenus()
    {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }
}

class VegRestaurant implements Hotel
{
    public Menus getMenus()
    {
        VegMenu v = new VegMenu();
        return v;
    }
}

class VegNonBothRestaurant implements Hotel
{
    public Menus getMenus()
    {
        Both b = new Both();
        return b;
    }
}

-------------------------------------------------

class HotelKeeper {

    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        VegMenu vegMenu = (VegMenu)v.getMenus();
        return vegMenu;
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant v = new NonVegRestaurant();
        NonVegMenu nonVegMenu = (NonVegMenu)v.getMenus();
        return nonVegMenu;
    }

    public Both getVegNonMenu() {
        VegNonBothRestaurant v = new VegNonBothRestaurant();
        Both bothMenu = (Both)v.getMenus();
        return bothMenu;
    }
}


-----------------------------------------------

public class Client {
    public static void main(String [] args)
    {
        HotelKeeper keeper = new HotelKeeper();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both b = keeper.getVegNonMenu();
    }
}

