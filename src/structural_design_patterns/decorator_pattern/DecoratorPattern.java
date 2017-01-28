package structural_design_patterns.decorator_pattern;

/**
 * Created by ashwin on 28/1/17.
 */

public class DecoratorPattern
{
    public static void main(String[] args)
    {
        System.out.println("Rectangle with normal border:");
        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        System.out.println("\nRectangle with red border:");
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(new Rectangle());
        redShapeDecorator.draw();

        System.out.println("\nCircle with red border:");
        redShapeDecorator = new RedShapeDecorator(new Circle());
        redShapeDecorator.draw();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class ShapeDecorator implements Shape
{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator
{
    public RedShapeDecorator(Shape decoratedShape)
    {
        super(decoratedShape);
    }

    @Override
    public void draw()
    {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder()
    {
        System.out.println("Border color: Red");
    }
}
