Facade Implementation

Participants

    Facade
        - know which subsystem classes are responsible for a request
        - delegates client requests to appropriate subsystem objects

    Subsystem classes
        - implment subsystem functionality
        - handle work assigned by the Facade objects
        - have no knowledge of the Facade (they keep no references to it)

    
Workflow
    Clients communicate with the subsystem by sending requests to the Facade

    The facade will forward the requests to the appropriate subsystem objects

    The subsystem objects perform the actual work
        - The facade may have to do work of its own to translate its interface
            to subsystem interfaces

    Clients that use the facase do not have to access its subsystem objects directly


Implementation issues
    The coupling between clients and the subsystem can be reduced even further
        - make the Facade an abstract class with concrete subclasses 
            for different implementations of a subsystem
            ; clients can communicate with the subsystem through the interface 
            of the abstract Facade class
            ; keeps clients from knowing which implementation of a subsystem is used
        
    An alternative to sub-classing is to configure a Facade object with different subsystem objects
        - to customize the facade, simply replace one or more of its subsystem objects
    
    Making subsystem classes private could also be useful
    

---------------------------------------------------------------------------------------------------------

public class Tuner {
	String description;
	Amplifier amplifier;
	double frequency;

	public Tuner(String description, Amplifier amplifier) {
		this.description = description;
	}

	public void on() {
		System.out.println(description + " on");
	}

	public void off() {
		System.out.println(description + " off");
	}

	public void setFrequency(double frequency) {
		System.out.println(description + " setting frequency to " + frequency);
		this.frequency = frequency;
	}

	public void setAm() {
		System.out.println(description + " setting AM mode");
	}

	public void setFm() {
		System.out.println(description + " setting FM mode");
	}

	public String toString() {
		return description;
	}
}

---------------------------------------------------------------------------------------------------------
public class Amplifier {
	String description;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	
	public Amplifier(String description) {
		this.description = description;
	}
 
	public void on() {
		System.out.println(description + " on");
	}
 
	public void off() {
		System.out.println(description + " off");
	}
 
	public void setStereoSound() {
		System.out.println(description + " stereo mode on");
	}
 
	public void setSurroundSound() {
		System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)");
	}
 
	public void setVolume(int level) {
		System.out.println(description + " setting volume to " + level);
	}

	public void setTuner(Tuner tuner) {
		System.out.println(description + " setting tuner to " + dvd);
		this.tuner = tuner;
	}
  
	public void setDvd(DvdPlayer dvd) {
		System.out.println(description + " setting DVD player to " + dvd);
		this.dvd = dvd;
	}
 
	public void setCd(CdPlayer cd) {
		System.out.println(description + " setting CD player to " + cd);
		this.cd = cd;
	}
 
	public String toString() {
		return description;
	}
}


---------------------------------------------------------------------------------------------------------
public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp,
                             Tuner tuner,
                             DvdPlayer dvd,
                             CdPlayer cd,
                             Projector projector,
                             Screen screen,
                             TheaterLights lights,
                             PopcornPopper popper) {

        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");

        popper.on();
        popper.pop();

        lights.dim(10);
        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);

        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}

--------------------------------------------------------------------------------------

public class Client {
    public static void main(String[] args)
    {
        Amplifier amp = new Amplifier("Top-O-Line Amplifier");
        Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
        CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
        Projector projector = new Projector("Top-O-Line Projector", dvd);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd,
                                                                projector, screen, lights, popper);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}