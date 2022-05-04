package lab4;

import java.util.HashMap;
import java.util.Map;

public class Street {

    private String name;
    private int length;
    private Intersection v1,v2;
   // private Map<String, Integer> streets = new HashMap<>();

    public Street(String name,int length)
    {
      this.name=name;
      this.length=length;
    }

    public void setAdjacency(Intersection v1,Intersection v2){
        this.v1=v1;
        this.v2=v2;

    }

    public int getLength()
    {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}'+ "\n";
    }

    public Intersection getV1() {
        return v1;
    }
    public Intersection getV2() {
        return v2;
    }
}
