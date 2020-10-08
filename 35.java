interface IntegerValueInterface {
    public int getInteger();
}

class IntegerValue implements IntegerValueInterface {
    @Override
    public int getInteger() {
        return 5;
    }
}

--------------------------------------------------------

class ClassAdapter extends IntegerValue {

    @Override
    public int getInteger() {
        return 2 + super.getInteger();
    }
}

class ObjectAdapter {
    private IntegerValueInterface myInt;

    public ObjectAdapter(IntegerValueInterface myInt) {
        this.myInt = myInt;
    }

    public int getInteger() {
        return 2 + this.myInt.getInteger();
    }
}

--------------------------------------------------------

public class Client {
    public static void main(String[] args) {
        System.out.println("***Class and Object Adapter Demo***");
        ClassAdapter ca1=new ClassAdapter();
        System.out.println("Class Adapter is returning :"+ca1.getInteger());

        ObjectAdapter oa=new ObjectAdapter(new IntegerValue());
        System.out.println("Object Adapter is returning :"+oa.getInteger());
    }
}