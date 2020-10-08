public interface VehicleBuilderInterface {
    void buildEssential();
    void addOptional();
    Vehicle getVehicle();
}

class MotorcycleBuilder implements VehicleBuilderInterface {
    private Vehicle motorcycle = new Vehicle();

    @Override
    public void buildEssential() {
        motorcycle.addItem(new Engine());
        motorcycle.addItem(new Body());
    }

    @Override
    public void addOptional() {
        motorcycle.addItem(new LedLight());
    }

    @Override
    public Vehicle getVehicle() {
        return motorcycle;
    }
}

class CarBuilder implements VehicleBuilderInterface{
    private Vehicle car = new Vehicle();

    @Override
    public void buildEssential() {
        car.addItem(new Engine());
        car.addItem(new Body());
    }

    @Override
    public void addOptional() {
        car.addItem(new PremiumAudio());
    }

    @Override
    public Vehicle getVehicle() {
        return car;
    }
}