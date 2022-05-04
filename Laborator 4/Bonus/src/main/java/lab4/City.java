package lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
   private Map<Intersection, List<Street>> cityMap = new HashMap<>();

   public City(){}

    public void put(Intersection key,List<Street> street)
    {
        cityMap.put(key,street);
    }

    /*public List<Street> get(Object key){
       return cityMap.get(key);
    }*/

    public Map<Intersection, List<Street>> getCity() {
        return cityMap;
    }

    public List<Street> getStreet(Intersection key){
        return cityMap.get(key);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityMap=" + cityMap +
                '}';
    }
}
