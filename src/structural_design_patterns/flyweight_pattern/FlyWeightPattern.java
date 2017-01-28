package structural_design_patterns.flyweight_pattern;

import java.util.HashMap;

/**
 * Created by ashwin on 25/1/17.
 */

public class FlyWeightPattern
{
    public static void main(String[] args)
    {
        Circle circle1 = (Circle) ShapeFactory.getCircle("Green");
        circle1.display();

        Circle circle2 = (Circle) ShapeFactory.getCircle("Red");
        circle2.display();

        Circle circle3 = (Circle) ShapeFactory.getCircle("Blue");
        circle3.display();

        // No need to create new object for red circle
        Circle circle4 = (Circle) ShapeFactory.getCircle("Red");
        circle4.display();
    }
}

interface Shape
{
    public void display();
}

class Circle implements Shape
{
    private String color = "";

    public Circle(String color)
    {
        this.color = color;
    }

    @Override
    public void display()
    {
        System.out.println(color + " circle");
    }
}

class ShapeFactory
{
    private static HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color)
    {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null)
        {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Created new circle " + color);
        }

        return circle;
    }
}
