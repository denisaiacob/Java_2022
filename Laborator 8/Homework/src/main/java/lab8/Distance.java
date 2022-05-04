package lab8;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Distance {

    public double getDistance(double lat1, double lat2, double lon1, double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return(c * r);
    }

    public void printDistance(String city1, String city2) throws SQLException {
        var serch=new CityDAO();
        double lat1 = serch.findCoordinates(city1).get(0);
        double lat2 = serch.findCoordinates(city1).get(1);
        double lon1 = serch.findCoordinates(city2).get(0);
        double lon2 = serch.findCoordinates(city2).get(1);
        System.out.println(getDistance(lat1, lat2, lon1, lon2) + " K.M");
    }

}
