public class Director {
    VehicleBuilderInterface myBuilder;

    public void construct(VehicleBuilderInterface builder){
        myBuilder = builder;
        myBuilder.buildEssential();
    }

    public void constructWithOption(VehicleBuilderInterface builder){
        myBuilder = builder;
        myBuilder.buildEssential();
        myBuilder.addOptional();
    }
}
