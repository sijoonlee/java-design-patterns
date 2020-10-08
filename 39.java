abstract class Shape {
    protected ColorInterface color;

    protected Shape (ColorInterface c) {
        this.color = c;
    }

    abstract void drawShape(int border);
    abstract void modifyBorder(int border, int increment);
}

class Triangle extends Shape {

    protected Triangle(ColorInterface c) {
        super(c);
    }

    // Implementer-specific method
    @Override
    void drawShape(int border) {
        System.out.print("This Triangle is colored with ");
        color.fillWithColor(border);
    }

    // abstraction-specific method
    @Override
    void modifyBorder(int border, int increment) {
        System.out.println("\nNow we are changing the border length " + increment + " times");
        border = border * increment;
        drawShape(border);


    }
}

class Rectangle extends Shape {

    protected Rectangle(ColorInterface c) {
        super(c);
    }

    // Implementer-specific method
    @Override
    void drawShape(int border) {
        System.out.print("This Rectangle is colored with ");
        color.fillWithColor(border);
    }

    // abstraction-specific method
    @Override
    void modifyBorder(int border, int increment) {
        System.out.println("\nNow we are changing the border length " + increment + " times");
        border = border * increment;
        drawShape(border);
    }
}

----------------------------------------------------------

public interface ColorInterface {
    void fillWithColor(int border);
}

class RedColor implements ColorInterface {
    @Override
    public void fillWithColor(int border) {
        System.out.print("Red color with " + border + " inch border");
    }
}

class GreenColor implements ColorInterface {
    @Override
    public void fillWithColor(int border) {
        System.out.print("Green color with " + border + " inch border");
    }
}

-----------------------------------------------------------

import java.awt.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("*****BRIDGE PATTERN*****");

        //Coloring Green to Triangle
        System.out.println("\nColoring Triangle:");
        ColorInterface green = new GreenColor();
        Shape triangleShape = new Triangle(green);
        triangleShape.drawShape(20);
        triangleShape.modifyBorder(20, 3);

        //Coloring Red to Rectangle
        System.out.println("\n\nColoring Rectangle :");
        ColorInterface red = new RedColor();
        Shape rectangleShape = new Rectangle(red);
        rectangleShape.drawShape(50);
        rectangleShape.modifyBorder(50, 2);
    }
}