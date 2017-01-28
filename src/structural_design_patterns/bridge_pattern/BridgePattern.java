package structural_design_patterns.bridge_pattern;

/**
 * Created by ashwin on 25/1/17.
 */

public class BridgePattern
{
    public static void main(String[] args)
    {
        Bridge bridge = new Bridge(new Square());
        bridge.display();

        bridge = new Bridge(new Circle());
        bridge.display();
    }
}

interface Shape
{
    public void display();
}

class Square implements Shape
{
    @Override
    public void display()
    {
        System.out.println("Square");
    }
}

class Circle implements Shape
{
    @Override
    public void display()
    {
        System.out.println("Circle");
    }
}

class Bridge
{
    public static Shape shape;

    public Bridge(Shape shape)
    {
        this.shape = shape;
    }

    public static void display()
    {
        shape.display();
    }
}


