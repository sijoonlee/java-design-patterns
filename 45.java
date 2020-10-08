Implementaion overview

    - decorator pattern will create a set of decorator classes to wrap concrete components

    - decorator classes mirror the type of the components they decorate
        ; they are the same type as the components they decorate

    - decorators change the behavior of their components by adding new functionality 
        before and/or after method calls to the component

    - You can warp a component with any number of decorators

    - Decorators are typically transparents to the client of the component
        unless the client is relying on the component's concrete type


Participants

    Component
        - defines the interface for objects
        - can have responsibilities added to them dynamically
    
    ConcreteComponent
        - defines an object to which additional responsibilities can be attached

    Decorator
        - maintains a reference to a Component object
        - defines an interface that conforms to Component's interface

    ConcreteDecorator
        - adds responsibilities to the component

    The Decorator forwards requests to its Component object
        - may optinoally perform additional operations before and after forwarding the request



----------------------Component.java-------------------------

abstract class Component {
    public abstract void doJob();
}

class ConcreteComponent extends Component {
    @Override
    public void doJob() {
        System.out.println("I am from a Concrete Component - I am closed for modification");
    }
}


----------------------AbstractDecorator.java-------------------------

abstract class AbstractDecorator extends Component {
    protected Component com;

    public void SetTheComponent(Component c) {
        com = c;
    }

    public void doJob() {
        if (com != null) {
            com.doJob();
        }
    }
}

class ConcreteDecoratorEx_1 extends AbstractDecorator {
    public void doJob() {
        super.doJob();

        // add additional responsibilities
        System.out.println("I am explicity from Ex_1");
    }
}

class ConcreteDecoratorEx_2 extends AbstractDecorator {
    public void doJob() {

        System.out.println("");
        System.out.println("***START Ex-2***");

        super.doJob();

        //Add additional thing if necessary
        System.out.println("Explicitly From DecoratorEx_2");
        System.out.println("***END. EX-2***");
    }
}


----------------------Client.java-------------------------

public class Client {
    public static void main(String[] args)
    {
        System.out.println("***Decorator pattern Demo***");
        ConcreteComponent cc = new ConcreteComponent();

        ConcreteDecoratorEx_1 cd_1 = new ConcreteDecoratorEx_1();

        // Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1
        cd_1.SetTheComponent(cc);
        cd_1.doJob();

        ConcreteDecoratorEx_2 cd_2= new ConcreteDecoratorEx_2();

        // Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1 & ConcreteDecoratorEX_2
        cd_2.SetTheComponent(cd_1);//Adding results from cd_1 now
        cd_2.doJob();
    }
}
