class Rectangle {
    public double length;
    public double width;
}

class Triangle {
    public double base;
    public double height;

    public Triangle(double b, double h)
    {
        base = b;
        height = h;
    }
}

-----------------------------------------------------

import org.w3c.dom.css.Rect;

public interface CalculatorInterface {
    // target interface
    public double getArea(Rectangle r);
}

class Calculator implements CalculatorInterface
{
    Rectangle rectangle;

    public double getArea(Rectangle r) {
        rectangle = r;
        return rectangle.length * rectangle.width;
    }
}

-----------------------------------------------------

public class CalculatorAdapter implements CalculatorInterface {
    Calculator calculator;
    Triangle t;

    public CalculatorAdapter(Triangle myTriangle) {
        t = myTriangle;
    }

    public double getArea(Rectangle r) {
        calculator = new Calculator();

        Rectangle rectangle = new Rectangle();

        rectangle.length = t.base;
        rectangle.width = 0.5 * t.height;

        return calculator.getArea(rectangle);

    }
}

-------------------------------------------------------

public class Client {

    public static void main (String [] args) {

        System.out.println("***Adapter Pattern Demo***");

        Triangle t = new Triangle(20, 10);

        CalculatorInterface calculatorAdapter = new CalculatorAdapter(t);

        System.out.println("Area of Triangle is: " + calculatorAdapter.getArea(null));
    }
}