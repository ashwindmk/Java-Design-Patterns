package structural_design_patterns.proxy_pattern;

/**
 * Created by ashwin on 24/1/17.
 */

public class ProxyPattern
{
    public static void main(String[] args)
    {
        ProxyImage proxyImage = new ProxyImage("mypicture.png");
        proxyImage.display();
    }
}

interface Image
{
    public void display();
}

class RealImage implements Image
{
    private String filename = "";

    public RealImage(String filename)
    {
        this.filename = filename;
    }

    @Override
    public void display()
    {
        System.out.println("Real image displayed : " + filename);
    }
}

class ProxyImage implements Image
{
    private RealImage realImage;
    private String filename = "";

    public ProxyImage(String filename)
    {
        this.filename = filename;
    }

    @Override
    public void display()
    {
        if(realImage == null)
        {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
