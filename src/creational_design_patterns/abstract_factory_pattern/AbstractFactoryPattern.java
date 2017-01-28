package creational_design_patterns.abstract_factory_pattern;

/**
 * Created by ashwin on 23/1/17.
 */

public class AbstractFactoryPattern
{
    public static void main(String[] args)
    {
        // Shape
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape shape = shapeFactory.getShape("square");

        shape.draw();

        // Color
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color color = colorFactory.getColor("Red");

        color.fill();
    }
}

// Factory producer
class FactoryProducer
{
    public static AbstractFactory getFactory(String choice)
    {
        if(choice == null)
        {
            return null;
        }

        if(choice.equalsIgnoreCase("SHAPE"))
        {
            return new ShapeFactory();
        }

        if(choice.equalsIgnoreCase("COLOR"))
        {
            return new ColorFactory();
        }

        return null;
    }
}

// Abstract factory
abstract class AbstractFactory
{
    abstract Shape getShape(String shape);
    abstract Color getColor(String color);
}

// Shape factory
class ShapeFactory extends AbstractFactory
{
    @Override
    Shape getShape(String shape)
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

    @Override
    Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory
{

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color)
    {
        if(color == null)
        {
            return null;
        }

        if(color.equalsIgnoreCase("RED"))
        {
            return new Red();
        }

        if(color.equalsIgnoreCase("BLUE"))
        {
            return new Blue();
        }

        return null;
    }
}


// Shape
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
    public void draw() {
        System.out.println("Inside Circle :: display()");
    }
}

// Color
interface Color
{
    public void fill();
}

class Red implements Color
{
    @Override
    public void fill()
    {
        System.out.println("Inside Red :: fill()");
    }
}

class Blue implements Color
{
    @Override
    public void fill()
    {
        System.out.println("Inside Blue :: fill()");
    }
}
