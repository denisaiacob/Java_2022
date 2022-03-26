package lab5;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();
    public Catalog() {}
    public Catalog(String name)
    {
        this.name=name;
    }
    public void add(Item item) {
        items.add(item);
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

