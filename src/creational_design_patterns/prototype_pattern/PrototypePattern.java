package creational_design_patterns.prototype_pattern;

import java.util.HashMap;

/**
 * Created by ashwin on 23/1/17.
 */

public class PrototypePattern
{
    public static void main(String[] args)
    {
        ShapeCache.loadCache();

        Shape shape = ShapeCache.getShape(1);
        shape.draw();

        shape = ShapeCache.getShape(2);
        shape.draw();
    }
}

class ShapeCache
{
    private static HashMap<Integer, Shape> shapeHashMap = new HashMap<>();

    public static void loadCache()
    {
        Square square = new Square();
        shapeHashMap.put(1, square);

        Circle circle = new Circle();
        shapeHashMap.put(2, circle);

        Rectangle rectangle = new Rectangle();
        shapeHashMap.put(3, rectangle);
    }

    public static Shape getShape(int id)
    {
        return shapeHashMap.get(id);
    }
}

abstract class Shape
{
    abstract void draw();
}

class Square extends Shape
{
    @Override
    void draw() {
        System.out.println("Square drawn");
    }
}

class Circle extends Shape
{
    @Override
    void draw() {
        System.out.println("Circle drawn");
    }
}

class Rectangle extends Shape
{
    @Override
    void draw() {
        System.out.println("Rectangle drawn");
    }
}
