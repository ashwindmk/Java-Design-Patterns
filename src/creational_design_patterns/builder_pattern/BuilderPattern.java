package creational_design_patterns.builder_pattern;

/**
 * Created by ashwin on 23/1/17.
 */

public class BuilderPattern
{
    public static void main(String[] args)
    {
        PizzaBuilder pizza = PizzaFactory.getPizzaBuilder("vegpizza");
        pizza.addBread();
        pizza.addVegies();
        pizza.addCheese();
        pizza.addMeat();
        pizza.pack();
        pizza.price();
    }
}

class PizzaFactory
{
    public static PizzaBuilder getPizzaBuilder(String pizza)
    {
        if(pizza == null)
        {
            return null;
        }

        if(pizza.equalsIgnoreCase("VEGPIZZA"))
        {
            return new VegPizza();
        }

        if(pizza.equalsIgnoreCase("CHICKENPIZZA"))
        {
            return new ChickenPizza();
        }

        return null;
    }
}

interface PizzaBuilder
{
    public void addBread();
    public void addVegies();
    public void addMeat();
    public void addCheese();
    public void pack();
    public void price();
}

class VegPizza implements PizzaBuilder
{
    @Override
    public void addBread() {
        System.out.println("Veg Pizza : Bread added");
    }

    @Override
    public void addVegies() {
        System.out.println("Veg Pizza : Vegies added");
    }

    @Override
    public void addMeat() {
        System.out.println("Veg Pizza : No meat");
    }

    @Override
    public void addCheese() {
        System.out.println("Veg Pizza : cheese added");
    }

    @Override
    public void pack() {
        System.out.println("Veg Pizza : packed");
    }

    @Override
    public void price() {
        System.out.println("Veg Pizza : price : $25.0");
    }
}

class ChickenPizza implements PizzaBuilder
{
    @Override
    public void addBread() {
        System.out.println("Chicken Pizza : Bread added");
    }

    @Override
    public void addVegies() {
        System.out.println("Chicken Pizza : Vegies added");
    }

    @Override
    public void addMeat() {
        System.out.println("Chicken Pizza : meat added");
    }

    @Override
    public void addCheese() {
        System.out.println("Chicken Pizza : cheese added");
    }

    @Override
    public void pack() {
        System.out.println("Chicken Pizza : packed");
    }

    @Override
    public void price() {
        System.out.println("Chicken Pizza : price : $35.0");
    }
}
