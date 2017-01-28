package behavioral_design_patterns.iterator_pattern;

/**
 * Created by ashwin on 28/1/17.
 */

public class IteratorPattern
{
    public static void main(String[] args)
    {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iterator = namesRepository.getIterator(); iterator.hasNext();)
        {
            String name = (String)iterator.next();
            System.out.println("Name : " + name);
        }
    }
}

interface Iterator {
    public boolean hasNext();
    public Object next();
}

interface Container {
    public Iterator getIterator();
}


class NameRepository implements Container
{
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // Iterator class
    private class NameIterator implements Iterator
    {
        int index;

        @Override
        public boolean hasNext() {

            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
