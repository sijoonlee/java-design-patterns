public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        VehicleBuilderInterface carBuilder = new CarBuilder();
        VehicleBuilderInterface premiumCarBuilder = new CarBuilder();
        VehicleBuilderInterface motorcycleBuilder = new MotorcycleBuilder();

        director.construct(carBuilder);
        Vehicle car = carBuilder.getVehicle();
        director.constructWithOption(premiumCarBuilder);
        Vehicle premiumCar = premiumCarBuilder.getVehicle();
        director.construct(motorcycleBuilder);
        Vehicle motorcycle = motorcycleBuilder.getVehicle();

        System.out.println("Car");
        car.showItems();
        System.out.println("Total Cost: " + car.getCost());

        System.out.println("Premium Car");
        premiumCar.showItems();
        System.out.println("Total Cost: " + premiumCar.getCost());

        System.out.println("Motorcycle");
        motorcycle.showItems();
        System.out.println("Total Cost: " + motorcycle.getCost());


    }
}
