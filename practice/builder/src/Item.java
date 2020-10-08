public interface  Item {
    public String name();
    public float price();
}

class Engine implements Item{
    @Override
    public String name() {
        return "Engine";
    }

    @Override
    public float price() {
        return 9000.0f;
    }
}

class Body implements Item{
    @Override
    public String name() {
        return "Chassis";
    }

    @Override
    public float price() {
        return 1000.0f;
    }
}

class LedLight implements Item{
    @Override
    public String name() {
        return "LED light";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}

class PremiumAudio implements Item{
    @Override
    public String name() {
        return "Premium Audio";
    }

    @Override
    public float price() {
        return 500.0f;
    }
}