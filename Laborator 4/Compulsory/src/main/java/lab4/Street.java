package lab4;

import java.util.HashMap;
import java.util.Map;

public class Street {

    private String name;
    private int length;
    //private Map<String, Integer> streets = new HashMap<>();

    public Street(String name,int length)
    {
        this.name=name;
        this.length=length;
    }
 /*   public void setLength(String name,int length)
    {
        streets.put(name,length);
    }*/

    public int getLength()
    {
        return length;
    }
}
