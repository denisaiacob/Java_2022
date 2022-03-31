package lab5;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Catalog implements Serializable {
    protected static List<Item> items = new ArrayList<>();
    private String name;
    public Catalog() {}
    public Catalog(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public static List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name +'\''+'\n' +
                " items=" + items +
                '}';
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);

    }
}

