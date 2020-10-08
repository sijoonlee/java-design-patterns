

interface AnimalInterface {
    void Speak();
}

class Duck implements AnimalInterface
{
    @Override
    public void Speak(){
        System.out.println("Duck says Pack-pack");
    }
}

class Tiger implements AnimalInterface
{
    @Override
    public void Speak() {
        System.out.println("Tiger says Halum-Halum");
    }
}

-----------------------------------------------------------

public abstract class AnimalFactoryInterface {
    public abstract AnimalInterface GetAnimalType(String type) throws Exception;
}

class ConcreteFactory extends AnimalFactoryInterface
{
    @Override
    public AnimalInterface GetAnimalType (String type) throws Exception
    {
        switch(type)
        {
            case "Duck":
                return new Duck();
           case "Tiger":
                return new Tiger();
            default:
                throw new Exception("Animal type: " + type + " cannot be instantiated");
        }
    }
}

-------------------------------------------------------------

public class Client {
    public static void main(String [] args) throws Exception
    {
        System.out.println("***Factory Pattern Demo***\n");
        AnimalFactoryInterface animalFactory = new ConcreteFactory();

        AnimalInterface duckType = animalFactory.GetAnimalType("Duck");
        duckType.Speak();

        AnimalInterface tigerType = animalFactory.GetAnimalType("Tiger");
        tigerType.Speak();

        AnimalInterface lionType = animalFactory.GetAnimalType("Lion");
        lionType.Speak();
    }
}