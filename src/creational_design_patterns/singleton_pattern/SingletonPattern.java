package creational_design_patterns.singleton_pattern;

/**
 * Created by ashwin on 23/1/17.
 */

public class SingletonPattern
{
    public static void main(String[] args)
    {
        SingletonEagerObject singletonEagerObject = SingletonEagerObject.getEagerInstance();
        singletonEagerObject.showMessage();

        SingletonLazyObject singletonLazyObject = SingletonLazyObject.getLazyInstance();
        singletonLazyObject.showMessage();
    }
}

// Eager instantiation
class SingletonEagerObject
{
    private static SingletonEagerObject eagerInstance = new SingletonEagerObject();

    private SingletonEagerObject() { }

    public static SingletonEagerObject getEagerInstance()
    {
        return eagerInstance;
    }

    public void showMessage()
    {
        System.out.println("Singleton object created (eager instantiation)");
    }
}

// Lazy instantiation
class SingletonLazyObject
{
    private static SingletonLazyObject lazyInstance;

    private SingletonLazyObject() { }

    public static SingletonLazyObject getLazyInstance()
    {
        if(lazyInstance == null)
        {
            lazyInstance = new SingletonLazyObject();
        }
        return lazyInstance;
    }

    public void showMessage()
    {
        System.out.println("Singleton object created (lazy instantiation)");
    }
}