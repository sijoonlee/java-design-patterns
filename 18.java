interface MovieFactoryInterface {
    HollyWoodMovieInterface GetHollyWoodMovie(String type);
    BollyWoodMovieInterface GetBollyWoodMovie(String type);
}

class HollyWoodMovieFactory implements MovieFactoryInterface {
    public HollyWoodMovieInterface GetHollyWoodMovie(String type)
    {
        if (type.equalsIgnoreCase("action"))
            return new HollyWoodActionMovie();
        else if (type.equalsIgnoreCase("comedy"))
            return new HollyWoodComedyMovie();

        return null;
    }

    public BollyWoodMovieInterface GetBollyWoodMovie(String type) {
        return null;
    }
}

class BollyWoodMovieFactory implements MovieFactoryInterface {
    public HollyWoodMovieInterface GetHollyWoodMovie(String type)
    {
        return null;
    }

    public BollyWoodMovieInterface GetBollyWoodMovie(String type) {
        if(type.equalsIgnoreCase("action"))
            return new BollyWoodActionMovie();
        else if (type.equalsIgnoreCase("comedy"))
            return new BollyWoodComedyMovie();

        return null;
    }
}


interface BollyWoodMovieInterface {
    String getMovieName();
}

class BollyWoodActionMovie implements BollyWoodMovieInterface {
    @Override
    public String getMovieName() {
        return "Bang Bang is a Bollywood Action Movie";
    }
}

class BollyWoodComedyMovie implements BollyWoodMovieInterface {
    @Override
    public String getMovieName() {
        return "Munna Bhai MBBS is a Bollywood Comedy Movie";
    }
}


interface HollyWoodMovieInterface {
    String getMovieName();
}

class HollyWoodActionMovie implements HollyWoodMovieInterface {
    @Override
    public String getMovieName()
    {
        return "True Lies is a Hollywood Action Movie";
    }
}

class HollyWoodComedyMovie implements HollyWoodMovieInterface {
    @Override
    public String getMovieName()
    {
        return "The Jerk is a Hollywood Comedy Movie";
    }
}

public class FactoryProducer {
    public static MovieFactoryInterface getFactory(String choice) {
        if (choice.equalsIgnoreCase("HollyWoodMovie")) {
            return new HollyWoodMovieFactory();
        } else if (choice.equalsIgnoreCase("BollyWoodMovie")) {
            return new BollyWoodMovieFactory();
        }

        return null;
    }
}

public class Client {

    public static void main(String[] args) {
        MovieFactoryInterface hollyWoodMovieFactory = FactoryProducer.getFactory("HollyWoodMovie");

        HollyWoodMovieInterface hAction = hollyWoodMovieFactory.GetHollyWoodMovie("action");
        HollyWoodMovieInterface hComedy = hollyWoodMovieFactory.GetHollyWoodMovie("comedy");

        System.out.println("\nHollyWood movies  are:");
        System.out.println(hAction.getMovieName());
        System.out.println(hComedy.getMovieName());

        MovieFactoryInterface bollyWoodMovieFactory = FactoryProducer.getFactory("BollyWoodMovie");

        BollyWoodMovieInterface bAction = bollyWoodMovieFactory.GetBollyWoodMovie("action");
        BollyWoodMovieInterface bComedy = bollyWoodMovieFactory.GetBollyWoodMovie("comedy");

        System.out.println("\nBollyWood movies  are:");
        System.out.println(bAction.getMovieName());
        System.out.println(bComedy.getMovieName());

    }
}   