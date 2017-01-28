package creational_design_patterns.factory_pattern;

/**
 * Created by ashwin on 23/1/17.
 */

public class FactoryPattern2
{
    public static void main(String[] args)
    {
        Shape shape = FactoryMethod.getShape("square");
        shape.draw();
    }
}

// Factory method
class FactoryMethod
{
    public static Shape getShape(String shape)
    {
        if(shape == null)
        {
            return null;
        }

        if(shape.equalsIgnoreCase("SQUARE"))
        {
            return new Square();
        }

        if(shape.equalsIgnoreCase("CIRCLE"))
        {
            return new Circle();
        }

        return null;
    }
}

interface Shape
{
    public void draw();
}

class Square implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Inside Square :: display()");
    }
}

class Circle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Inside Circle :: display()");
    }
}
