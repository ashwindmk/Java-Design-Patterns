package creational_design_patterns.factory_pattern;

/**
 * Created by ashwin on 23/1/17.
 */

public class FactoryPattern
{
    public static void main(String[] args)
    {
        //String planType = "institutional";
        String planType = "commercial";
        //String planType = "domestic";

        Plan plan = GetPlanFactory.getPlan(planType);

        plan.getRate();

        plan.calculateBill(10);
    }
}

abstract class Plan
{
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units)
    {
        System.out.println("$" + units * rate );
    }
}

class GetPlanFactory
{
    public static Plan getPlan(String planType)
    {
        if(planType == null)
        {
            return null;
        }

        if(planType.equalsIgnoreCase("DOMESTIC"))
        {
            return new DomesticPlan();
        }

        if(planType.equalsIgnoreCase("INSTITUTIONAL"))
        {
            return new InstitutionalPlan();
        }

        if(planType.equalsIgnoreCase("COMMERCIAL"))
        {
            return new CommercialPlan();
        }

        return null;
    }
}

class DomesticPlan extends Plan
{
    void getRate() { rate = 3.50; }
}

class InstitutionalPlan extends Plan
{
    void getRate() { rate = 5.50; }
}

class CommercialPlan extends Plan
{
    void getRate() { rate = 7.50; }
}
