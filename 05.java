SINGLE RESPONSIBILITY PRINCIPLE

    states that every class should have responsibility over a single part 
        of the functionality provided by the software
        - the responsibility should be entirely encapsulated by the class
        - all its methods should be narrowly aligned with that responsibility
        - a class should have only one job
    
    "a class should have a single responsibility, 
        where a responsibility is nothing but a reason to change"

    should make sure that one class at the most is responsible for doing one task
        or functionality among the whole set of responsibilites that it has
        - only when there is a change needed in that specific task 
            or functionality should this class be changed

    the Single Responsibility Principle is closely related to 
        the concepts of coupling and cohesion

    coupling is the degree of interdependence between software classes or methods
        - a measure of how closely connected two classes or two methods are
        - the strength of the relationships between classes
        - low coupling: small dependencies between classes/methods
        - tight coupling: two classes/methods are closely connected
    
    cohesion referes to what the class(or method) can do
        - low cohesion: the class does a great variety of actions
        - hight cohesion: the class is focused, 
            only has methods relating to the intention of the class

    the single responsibility principle is about limiting 
        the impact of change by desigining loosely(low) coupled classes 
        that are highly cohesive

    examples of responsibilites
        - Persistence
        - Validation
        - Notification
        - Error Handling
        - Logging
        - Class Selection / Instantiation
        - Formatting
        - Parsing
        - Mapping

import java.util.Date;

public class Employee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

   // getters / setters for all member variables

// this method should not be here
    // public boolean isPromotionDueThisYear(Employee emp){
    //     // promotion logic implmentation is using the employee information passed in
    //     return true;
    // }

// this method should not be here
    // public double calcIncomeTaxForCurrentYear(Employee emp) {
    //     // income tax logic using employee passed in
    //     return 0.0;
    // }
}

public class HRPromotions {

    public boolean isPromotionDueThisYear(Employee emp){
        // promotion logic implmentation is using the employee information passed in
        return true;
    }
}

public class Finance {
    public double calcIncomeTaxForCurrentYear(Employee emp) {
        // income tax logic using employee passed in
        return 0.0;
    }
}


import java.util.Date;

public class Employee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

   // getters / setters for all member variables
}

public class Finance {
    public double calcIncomeTaxForCurrentYear(Employee emp) {
        // income tax logic using employee passed in
        return 0.0;
    }
}

public class HRPromotions {

    public boolean isPromotionDueThisYear(Employee emp){
        // promotion logic implmentation is using the employee information passed in
        return true;
    }
}